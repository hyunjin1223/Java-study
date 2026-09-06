package basic.control_flow;

import java.util.Scanner;

// switch문
// - 특정 '값'이 일치하는 케이스로 바로 이동 (동등 비교만 가능)
// - byte, short, char, int, String, enum 지원 (float, double은 오차 때문에 사용 불가)
// - break 없으면 밑에 있는 case까지 다 실행됨 (fall-through)
public class SwitchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("권한 입력 (Admin/Manager/User): ");
        String role = sc.nextLine();

        // 기본 switch
        switch (role) {
            case "Admin":
                System.out.println("최고 관리자 권한");
                break;
            case "Manager":
                System.out.println("매니저 권한");
                break;
            default:
                System.out.println("일반 사용자 권한");
                break;
        }

        // Java 14+ 화살표 문법 (break 필요 없고 값 반환 가능)
        int level = switch (role) {
            case "Admin" -> 1;
            case "Manager" -> 2;
            default -> 3;
        };
        System.out.println("권한 레벨: " + level);

        sc.close();
    }
}