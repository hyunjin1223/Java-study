package basic.control_flow;

// continue
// - 반복문을 종료하지 않고, 이번 회차 밑의 코드만 건너뛰어 다음 반복으로 넘어감
// - for문은 바로 '증감식'으로 가고, while문은 '조건식'으로 이동
public class ContinueExample {
    public static void main(String[] args) {

        System.out.println("1~10 중 짝수만 출력:");

        for (int k = 1; k <= 10; k++) {
            if (k % 2 != 0) {
                continue; // 홀수면 아래 print 건너뛰고 바로 k++ 이동
            }
            System.out.print(k + " ");
        }

        System.out.println();
    }
}