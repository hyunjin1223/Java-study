package data_io.network.chat;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// TCP 채팅 클라이언트
// - 서버에 접속한 후 닉네임과 메시지를 보낸다.
// - 수신 스레드가 서버에서 전달되는 메시지를 읽는다.
// - q를 입력하면 채팅 연결을 종료한다.

public class ChatClientBasic {

    private static final String HOST = "localhost";
    private static final int PORT = 50002;

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("닉네임: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                name = "Guest";
            }

            try (Socket socket = new Socket(HOST, PORT);
                 DataInputStream input =
                         new DataInputStream(socket.getInputStream());
                 DataOutputStream output =
                         new DataOutputStream(socket.getOutputStream())) {

                System.out.println("[클라이언트] 서버 연결 성공");

                // 서버에 입장 요청
                JSONObject join = new JSONObject();
                join.put("command", "join");
                join.put("name", name);
                send(output, join);

                // 서버에서 오는 메시지를 별도 스레드로 수신
                Thread receiver = new Thread(() -> {
                    try {
                        while (true) {
                            String data;

                            try {
                                data = input.readUTF();
                            } catch (EOFException e) {
                                break;
                            }

                            JSONObject response = new JSONObject(data);
                            String type = response.optString("type");
                            String sender = response.optString("name");
                            String message = response.optString("message");

                            if (type.equals("system")) {
                                System.out.println("[알림] " + message);
                            } else {
                                System.out.println(sender + ": " + message);
                            }
                        }

                    } catch (IOException e) {
                        // 연결이 끊어지면 수신 스레드 종료
                    } catch (RuntimeException e) {
                        System.err.println("[메시지 처리 오류]");
                    }
                }, "chat-receiver");

                receiver.setDaemon(true);
                receiver.start();

                System.out.println("메시지를 입력하세요. 종료하려면 q를 입력합니다.");

                while (scanner.hasNextLine()) {
                    String message = scanner.nextLine();

                    if (message.equalsIgnoreCase("q")) {
                        JSONObject leave = new JSONObject();
                        leave.put("command", "leave");
                        send(output, leave);
                        break;
                    }

                    if (message.isBlank()) {
                        continue;
                    }

                    // 서버로 메시지 전송
                    JSONObject request = new JSONObject();
                    request.put("command", "message");
                    request.put("message", message);
                    send(output, request);

                    // 서버는 보낸 사람을 제외하므로 내 화면에는 직접 출력
                    System.out.println("나: " + message);
                }

            } catch (IOException e) {
                System.err.println("[클라이언트 오류] "
                        + e.getClass().getSimpleName());
            }

        }
    }

    // JSON 메시지를 서버로 전송
    private static void send(
            DataOutputStream output, JSONObject json) throws IOException {

        output.writeUTF(json.toString());
        output.flush();
    }
}