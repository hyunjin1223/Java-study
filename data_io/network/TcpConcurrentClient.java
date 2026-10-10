package data_io.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// TCP 동시 처리 클라이언트
// - 서버에 연결한 뒤 메시지를 전송하고 응답을 받는다.
// - 여러 클라이언트를 실행하여 서버의 동시 요청 처리를 확인할 수 있다.
// - 서버와 동일하게 writeUTF()와 readUTF()로 문자열을 주고받는다.

public class TcpConcurrentClient {

    private static final int PORT = 50001;

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", PORT);
             Scanner scanner = new Scanner(System.in);
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {

            System.out.println("[클라이언트] 서버 연결 성공");
            System.out.print("전송할 메시지: ");

            String message = scanner.nextLine();

            // 서버에 메시지 전송
            output.writeUTF(message);
            output.flush();

            System.out.println("[클라이언트] 메시지 전송 완료");

            // 서버의 응답 수신
            String response = input.readUTF();

            System.out.println("[서버 응답] " + response);

        } catch (IOException e) {
            System.err.println("[클라이언트 오류] " + e.getMessage());
        }
    }
}