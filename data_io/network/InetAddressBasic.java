package data_io.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

// IP 주소 확인
// - InetAddress는 컴퓨터의 호스트 이름과 IP 주소를 다룬다.
// - getLocalHost()는 현재 컴퓨터의 호스트 정보를 가져온다.
// - getByName()은 도메인 이름으로 IP 주소를 조회한다.
// - getAllByName()은 해당 도메인에 연결된 IP 주소들을 배열로 반환한다.

public class InetAddressBasic {

    public static void main(String[] args) {

        try {
            // 현재 컴퓨터의 호스트 정보 확인
            InetAddress local = InetAddress.getLocalHost();

            System.out.println("[현재 컴퓨터]");
            System.out.println("호스트 이름: " + local.getHostName());
            System.out.println("IP 주소: " + local.getHostAddress());

            System.out.println();

            // 도메인 이름으로 IP 주소 조회
            String domain = "example.com";
            InetAddress address = InetAddress.getByName(domain);

            System.out.println("[도메인 조회]");
            System.out.println("도메인 이름: " + domain);
            System.out.println("IP 주소: " + address.getHostAddress());

            System.out.println();

            // 도메인에 연결된 모든 IP 주소 확인
            InetAddress[] addresses = InetAddress.getAllByName(domain);

            System.out.println("[IP 주소 목록]");
            for (InetAddress item : addresses) {
                System.out.println(item.getHostAddress());
            }

        } catch (UnknownHostException e) {
            // 호스트 이름을 확인할 수 없거나 DNS 조회에 실패한 경우
            System.err.println("호스트 정보를 가져오지 못했습니다.");
            e.printStackTrace();
        }
    }
}