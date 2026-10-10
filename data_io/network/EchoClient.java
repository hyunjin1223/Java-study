package data_io.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// TCP 에코 클라이언트
// - Socket으로 서버에 연결한다.
// - writeUTF()로 메시지를 보내고 readUTF()로 응답을 받는다.
// - /quit를 입력하면 서버에 종료 요청을 보낸다.

public class EchoClient {

    private static final int PORT = 50002;

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", PORT);
             Scanner scanner = new Scanner(System.in)) {

            DataInputStream input =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream output =
                    new DataOutputStream(socket.getOutputStream());

            System.out.println("[클라이언트] 연결 성공");

            while (true) {
                System.out.print("메시지 입력 (/quit 종료): ");
                String message = scanner.nextLine();

                // 서버로 메시지 전송
                output.writeUTF(message);
                output.flush();

                // 서버의 응답 수신
                String response = input.readUTF();
                System.out.println("[서버 응답] " + response);

                if (message.equalsIgnoreCase("/quit")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("[클라이언트 오류] " + e.getMessage());
        }
    }
}