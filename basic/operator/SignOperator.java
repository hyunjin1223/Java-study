package basic.operator;

// 부호 연산자 (+, -) 및 타입 변환 주의점
public class SignOperator {
    public static void main(String[] args) {
        int x = -50;
        x = -x; // 부호 반전 -> 50
        System.out.println("x: " + x);

        byte b = 100;
        // byte res = -b; // 에러: 부호 연산 결과는 int 타입
        int res = -b;
        System.out.println("res: " + res);
    }
}