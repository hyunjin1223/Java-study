package data_io.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// TCP 서버 연결
// - ServerSocket은 지정한 포트에서 연결 요청을 기다린다.
// - accept()는 클라이언트가 연결될 때까지 대기한다.
// - 연결이 수락되면 해당 클라이언트와 통신할 Socket을 반환한다.

public class TcpServerBasic {

    private static final int PORT = 50001;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("[서버] 연결 대기 중");

            // 클라이언트 연결 수락
            try (Socket clientSocket = serverSocket.accept()) {

                System.out.println("[서버] 연결 성공");
                System.out.println("클라이언트 IP: " + clientSocket.getInetAddress().getHostAddress());
                System.out.println("클라이언트 포트: " + clientSocket.getPort());
            }

            // 클라이언트 연결 종료 후 서버도 종료
            System.out.println("[서버] 종료");

        } catch (IOException e) {
            System.err.println("[서버 오류] " + e.getMessage());
        }
    }
}