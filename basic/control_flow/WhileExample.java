package basic.control_flow;

import java.util.Scanner;

// while & do-while
// - while: 조건이 true인 동안 반복 (반복 횟수가 유동적일 때)
// - do-while: 일단 무조건 1번 실행하고 나서 조건 검사 (끝에 세미콜론 ; 필수)
public class WhileExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // while 문
        boolean isRunning = true;
        int speed = 0;

        while (isRunning) {
            System.out.print("\n1.증속 | 2.감속 | 3.중지 : ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                speed++;
                System.out.println("현재 속도: " + speed);
            } else if (choice.equals("2")) {
                speed--;
                System.out.println("현재 속도: " + speed);
            } else if (choice.equals("3")) {
                isRunning = false; // 루프 종료 조건
            }
        }

        // do-while 문
        String input;
        do {
            System.out.print("종료하려면 q 입력: ");
            input = sc.nextLine();
        } while (!input.equalsIgnoreCase("q"));

        System.out.println("프로그램 종료");
        sc.close();
    }
}