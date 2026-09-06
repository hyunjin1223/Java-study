package basic.operator;

// 비트 이동 연산자(<<, >>, >>>) 및 바이트 분리
public class BitShiftOperator {
    public static void main(String[] args) {
        // 1. 좌측 시프트 (<<) : a * 2^b
        int num1 = 1;
        System.out.println("1 << 3 : " + (num1 << 3)); // 8 (1 * 2^3)

        // 2. 우측 시프트 (>>) : 부호 비트 유지 (a / 2^b)
        int num2 = -8;
        System.out.println("-8 >> 3 : " + (num2 >> 3)); // -1 (-8 / 2^3)

        // 3. 논리 우측 시프트 (>>>) : 최상위 비트를 무조건 0으로 채움 (양수 전환)
        System.out.println("-8 >>> 3 : " + (num2 >>> 3)); // 536870911

        // 4. 4바이트 정수(772)에서 바이트 단위 추출 (바이트 마스킹)
        int val = 772; // 0x00000304

        int b1 = (val >>> 24) & 255;
        int b2 = (val >>> 16) & 255;
        int b3 = (val >>> 8) & 255;
        int b4 = val & 255;

        System.out.println("Byte 1: " + b1); // 0
        System.out.println("Byte 2: " + b2); // 0
        System.out.println("Byte 3: " + b3); // 3
        System.out.println("Byte 4: " + b4); // 4
    }
}