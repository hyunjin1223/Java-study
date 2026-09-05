package Basic.Operator;

// 산술 연산자 (+, -, *, /, %) 및 자동 형변환
public class ArithmeticOperator {
    public static void main(String[] args) {
        int v1 = 10;
        int v2 = 4;
        long v3 = 20L;

        int sum = v1 + v2;
        long sub = v3 - v1; // long이 섞여 있으면 결과도 long
        double div = (double) v1 / v2; // 2.5 (캐스팅 필요)
        int mod = v1 % v2; // 나머지 연산 (2)

        System.out.println("sum: " + sum);
        System.out.println("sub: " + sub);
        System.out.println("div: " + div);
        System.out.println("mod: " + mod);
    }
}