package basic.operator;

// 복합 대입 연산자 및 삼항(조건) 연산자
public class AssignmentAndConditional {
    public static void main(String[] args) {
        // 1. 복합 대입 연산자
        int res = 0;
        res += 10; // 10
        res -= 5;  // 5
        res *= 3;  // 15
        res /= 5;  // 3
        res %= 3;  // 0
        System.out.println("최종 res: " + res);

        // 2. 삼항 연산자 (중첩 조건문 처리)
        int score = 85;
        char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
        System.out.println(score + "점은 " + grade + "등급입니다.");
    }
}