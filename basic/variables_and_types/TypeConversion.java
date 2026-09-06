package basic.variables_and_types;

// 자바 타입 변환 (자동/강제 변환, 연산 시 변환, 문자열 변환)
public class TypeConversion {
    public static void main(String[] args) {

        // 1. 기본 타입 변환 & 캐스팅
        int num = 100;
        double dNum = num; // 자동 변환 (int -> double)

        double pi = 3.14159;
        int intPi = (int) pi; // 강제 변환 (소수점 자름) -> 3

        // 2. 연산 시 타입 변환 & 나눗셈
        int a = 5;
        int b = 2;
        double divResult = (double) a / b; // 2.5 (캐스팅 안하면 2.0)

        // 3. 문자열 결합 연산 (+)
        String str1 = 10 + 20 + "8";   // "30" + "8" -> "308"
        String str2 = "10" + (20 + 8); // "10" + 28  -> "1028"

        // 4. 문자열 <-> 기본 타입 변환
        int parsedInt = Integer.parseInt("200");
        double parsedDouble = Double.parseDouble("12.34");
        boolean parsedBool = Boolean.parseBoolean("true");

        String convertedStr = String.valueOf(1000);

        // 결과 출력 확인
        System.out.println("intPi: " + intPi);
        System.out.println("divResult: " + divResult);
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("parsedInt: " + (parsedInt + 100)); // 300
        System.out.println("convertedStr: " + convertedStr);
    }
}