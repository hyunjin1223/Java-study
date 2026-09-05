package Basic.VariablesAndTypes;

import java.util.Scanner;

// 키보드 입력(Scanner) 및 문자열 동등 비교(.equals)
public class ConsoleInput {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 1. 단가와 수량을 입력받아 계산
        System.out.print("단가: ");
        int price = Integer.parseInt(sc.nextLine());

        System.out.print("수량: ");
        int qty = Integer.parseInt(sc.nextLine());

        System.out.println("총금액: " + (price * qty) + "원");
        System.out.println();

        // 2. 명령어 반복 입력 처리
        while (true) {
            System.out.print("입력 (종료는 'exit'): ");
            String cmd = sc.nextLine();

            // 문자열 비교 시 == 대신 .equals() 사용
            if (cmd.equals("exit")) {
                break;
            }
            System.out.println("입력값: " + cmd);
        }

        System.out.println("프로그램 종료");
        sc.close();
    }
}