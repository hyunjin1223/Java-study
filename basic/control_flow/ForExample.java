package basic.control_flow;

// for문
// - 반복 횟수가 명확할 때 사용
// - 구조: (초기화식; 조건식; 증감식)
// - for문 안에서 선언한 카운터 변수는 외부에서 사용 불가 (Scope)
// - 카운터 변수로 float 쓰면 연산 오차 때문에 무한루프 날 수 있으니 int 쓰기
public class ForExample {
    public static void main(String[] args) {

        int sum = 0;
        int i; // 루프 끝나고도 참조하려고 외부에 선언

        for (i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1부터 " + (i - 1) + "까지 합: " + sum);

        // 중첩 for문 (구구단)
        for (int dan = 2; dan <= 3; dan++) {
            System.out.println("\n=== " + dan + "단 ===");
            for (int num = 1; num <= 9; num++) {
                System.out.println(dan + " x " + num + " = " + (dan * num));
            }
        }
    }
}