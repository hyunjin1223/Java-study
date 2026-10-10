package data_io.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

// UDP 클라이언트 기본
// - DatagramPacket에 목적지 주소와 포트를 지정해 데이터를 보낸다.
// - 서버의 응답도 DatagramPacket으로 수신한다.
// - UDP는 응답이 도착한다는 보장이 없으므로 수신 시간 제한을 둘 수 있다.

public class UdpClientBasic {

    private static final int PORT = 50003;

    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket()) {

            socket.setSoTimeout(3000);

            String message = "UDP 메시지";
            byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

            // 서버 주소와 포트를 포함한 전송용 패킷 생성
            DatagramPacket request = new DatagramPacket(
                    bytes,
                    bytes.length,
                    new InetSocketAddress("localhost", PORT)
            );

            socket.send(request);
            System.out.println("[보냄] " + message);

            // 서버 응답 수신
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);

            socket.receive(response);

            String result = new String(
                    response.getData(),
                    response.getOffset(),
                    response.getLength(),
                    StandardCharsets.UTF_8
            );

            System.out.println("[서버 응답] " + result);

        } catch (SocketTimeoutException e) {
            System.err.println("서버 응답을 기다리는 시간이 초과되었습니다.");
        } catch (IOException e) {
            System.err.println("[UDP 클라이언트 오류] " + e.getMessage());
        }
    }
}