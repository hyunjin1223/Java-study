package data_io.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// TCP 에코 서버
// - 클라이언트가 보낸 메시지를 읽어 다시 전송한다.
// - DataInputStream과 DataOutputStream으로 문자열을 주고받는다.
// - /quit 메시지를 받으면 해당 클라이언트와의 연결을 종료한다.

public class EchoServer {

    private static final int PORT = 50002;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("[서버] 시작");
            System.out.println("[서버] 종료하려면 프로그램을 중지하세요.");

            // 클라이언트 연결을 계속 수락
            while (true) {
                System.out.println("[서버] 연결 대기 중");

                try (Socket clientSocket = serverSocket.accept()) {

                    System.out.println("[서버] 연결됨: "
                            + clientSocket.getInetAddress().getHostAddress());

                    handleClient(clientSocket);

                } catch (IOException e) {
                    System.err.println("[서버] 연결 처리 오류: "
                            + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("[서버 오류] " + e.getMessage());
        }
    }

    private static void handleClient(Socket socket) throws IOException {

        try (DataInputStream input =
                     new DataInputStream(socket.getInputStream());
             DataOutputStream output =
                     new DataOutputStream(socket.getOutputStream())) {

            while (true) {
                String message;

                try {
                    message = input.readUTF();
                } catch (EOFException e) {
                    // 상대방이 먼저 연결을 종료한 경우
                    break;
                }

                System.out.println("[받음] " + message);

                if (message.equalsIgnoreCase("/quit")) {
                    output.writeUTF("연결을 종료합니다.");
                    output.flush();
                    break;
                }

                // 받은 메시지를 응답으로 다시 전송
                output.writeUTF("에코: " + message);
                output.flush();
            }
        }

        System.out.println("[서버] 클라이언트 연결 종료");
    }
}