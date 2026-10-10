package data_io.network;

import java.io.IOException;
import java.net.Socket;

// TCP 클라이언트 연결
// - Socket 생성 시 서버 주소와 포트를 지정하면 연결을 요청한다.
// - 연결에 성공하면 서버와 통신할 수 있는 상태가 된다.
// - try-with-resources를 사용하면 연결을 자동으로 종료한다.

public class TcpClientBasic {

    private static final int PORT = 50001;

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", PORT)) {

            System.out.println("[클라이언트] 연결 성공");
            System.out.println("서버 주소: " + socket.getInetAddress().getHostAddress());
            System.out.println("서버 포트: " + socket.getPort());

        } catch (IOException e) {
            System.err.println("[클라이언트 오류] " + e.getMessage());
        }
    }
}