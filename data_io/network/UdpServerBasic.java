package data_io.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

// UDP 서버 기본
// - DatagramSocket은 지정한 포트에서 UDP 데이터를 주고받는다.
// - receive()는 데이터그램이 도착할 때까지 대기한다.
// - 받은 패킷에는 보낸 클라이언트의 주소와 포트 정보도 포함된다.

public class UdpServerBasic {

    private static final int PORT = 50003;

    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket(PORT)) {

            byte[] buffer = new byte[1024];
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);

            System.out.println("[UDP 서버] 수신 대기 중");

            // 클라이언트가 보낸 데이터그램 수신
            socket.receive(request);

            String message = new String(
                    request.getData(),
                    request.getOffset(),
                    request.getLength(),
                    StandardCharsets.UTF_8
            );

            System.out.println("[받음] " + message);
            System.out.println("[보낸 주소] " + request.getSocketAddress());

            // 응답을 보낼 때는 요청 패킷의 주소와 포트를 사용
            byte[] responseBytes =
                    ("서버 응답: " + message).getBytes(StandardCharsets.UTF_8);

            DatagramPacket response = new DatagramPacket(
                    responseBytes,
                    responseBytes.length,
                    request.getSocketAddress()
            );

            socket.send(response);
            System.out.println("[UDP 서버] 응답 전송 완료");

        } catch (IOException e) {
            System.err.println("[UDP 서버 오류] " + e.getMessage());
        }
    }
}