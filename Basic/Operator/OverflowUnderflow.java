package Basic.Operator;

// 정수 타입의 오버플로우(Overflow)와 언더플로우(Underflow)
public class OverflowUnderflow {
    public static void main(String[] args) {
        // 1. byte 오버플로우 (최댓값 127 + 1 -> 최저값 -128)
        byte maxByte = 127;
        maxByte++;
        System.out.println("byte 오버플로우: " + maxByte); // -128

        // 2. byte 언더플로우 (최저값 -128 - 1 -> 최댓값 127)
        byte minByte = -128;
        minByte--;
        System.out.println("byte 언더플로우: " + minByte); // 127

        // 3. 연산 중 오버플로우 방지 (long 타입 형변환)
        int x = 1_000_000;
        int y = 2_000_000;

        // int result = x * y; // 오버플로우 발생 (쓰레기값)
        long safeResult = (long) x * y; // 피연산자 중 하나를 long으로 변환
        System.out.println("안전한 연산 결과: " + safeResult); // 2000000000000
    }
}