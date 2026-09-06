package basic.operator;

// 증감 연산자 (++ / -- 전위, 후위)
public class IncDecOperator {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;

        // 전위 연산자: 값 먼저 증가 후 대입
        int res1 = ++a;
        // 후위 연산자: 대입 먼저 수행 후 값 증가
        int res2 = b++;

        System.out.println("res1(++a): " + res1 + ", a: " + a); // 11, 11
        System.out.println("res2(b++): " + res2 + ", b: " + b); // 10, 11

        // 혼합 연산 예시
        int x = 5;
        int y = 5;
        int total = ++x + y++; // 6 + 5
        System.out.println("total: " + total + ", x: " + x + ", y: " + y);
    }
}