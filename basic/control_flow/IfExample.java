package basic.control_flow;

import java.util.Scanner;

// if문
// - 조건식 결과(boolean)에 따라 실행 흐름 결정
// - 위에서부터 순서대로 검사하다가 true 나오면 해당 블록만 실행하고 바로 탈출
public class IfExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("점수 입력 (0~100): ");
        int score = sc.nextInt();

        if (score >= 90) {
            System.out.println("A등급");
        } else if (score >= 80) { // 90 미만 조건은 자동으로 전제됨
            System.out.println("B등급");
        } else if (score >= 70) {
            System.out.println("C등급");
        } else {
            System.out.println("D등급");
        }

        sc.close();
    }
}