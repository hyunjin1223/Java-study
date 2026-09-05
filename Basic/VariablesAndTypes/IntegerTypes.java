package Basic.VariablesAndTypes;

// 정수 리터럴 진수 표현 및 타입별 특징
public class IntegerTypes {
    public static void main(String[] args) {

        // 진수별 표현법 (2진수, 8진수, 10진수, 16진수)
        int bin = 0b1101;   // 2진수 (0b) -> 13
        int oct = 017;      // 8진수 (0)  -> 15
        int dec = 100;      // 10진수     -> 100
        int hex = 0x1F;     // 16진수 (0x) -> 31

        System.out.println("bin: " + bin);
        System.out.println("hex: " + hex);


        // byte 타입 범위 (-128 ~ 127)
        byte minVal = -128;
        byte maxVal = 127;
        // byte limitOver = 130; // 허용 범위 초과 시 컴파일 에러


        // long 타입과 L 접미사
        // 기본 정수 리터럴은 int로 처리되므로 int 범위를 초과하면 L 필수
        long smallNum = 50;
        long bigNum = 5000000000L;

        System.out.println("bigNum: " + bigNum);
    }
}