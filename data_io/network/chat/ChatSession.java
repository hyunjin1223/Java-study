package data_io.network.chat;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

// 클라이언트별 통신 처리
// - 연결된 소켓에서 메시지를 읽고 요청 종류에 따라 처리한다.
// - 메시지는 JSON 문자열로 주고받는다.
// - 연결이 종료되면 서버의 클라이언트 목록에서 제거한다.

public class ChatSession implements Runnable {

    private final ChatServerBasic server;
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;

    private String name = "Guest";
    private boolean joined;

    public ChatSession(ChatServerBasic server, Socket socket)
            throws IOException {

        this.server = server;
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                String data;

                try {
                    data = input.readUTF();
                } catch (EOFException e) {
                    // 상대방이 연결을 정상적으로 종료한 경우
                    break;
                }

                JSONObject request;

                try {
                    request = new JSONObject(data);
                } catch (RuntimeException e) {
                    System.err.println("[잘못된 JSON 메시지]");
                    continue;
                }

                String command = request.optString("command", "");

                switch (command) {
                    case "join":
                        if (!joined) {
                            String requestedName = request.optString("name", "Guest").trim();

                            name = requestedName.isEmpty() ? "Guest" : requestedName;

                            joined = true;
                            server.clientJoined(this);
                        }
                        break;

                    case "message":
                        if (joined) {
                            String message =
                                    request.optString("message", "").trim();

                            if (!message.isEmpty()) {
                                server.broadcastMessage(this, message);
                            }
                        }
                        break;

                    case "leave":
                        return;

                    default:
                        System.out.println("[서버] 알 수 없는 요청");
                        break;
                }
            }

        } catch (IOException e) {
            if (server.isRunning() && !socket.isClosed()) {
                System.err.println("[통신 오류] " + e.getClass().getSimpleName());
            }

        } finally {
            if (joined) {
                server.clientLeft(this);
            }
            close();
        }
    }

    // 다른 클라이언트에게 보낼 JSON 메시지 전송
    public synchronized void send(String message) throws IOException {
        output.writeUTF(message);
        output.flush();
    }

    public String getName() {
        return name;
    }

    // 클라이언트 연결 종료
    public void close() {
        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }
}