package library.java_base.wrapper_class;

// 문자열을 기본 타입 값으로 변환
// - 포장 클래스의 parseXxx() 메서드를 사용할 수 있다.
// - 문자열로 입력받은 숫자를 계산에 사용할 때 유용하다.

public class WrapperParse {

    public static void main(String[] args) {

        String intText = "250";
        String doubleText = "3.14";
        String booleanText = "true";

        // String -> int
        int number = Integer.parseInt(intText);

        // String -> double
        double decimal = Double.parseDouble(doubleText);

        // String -> boolean
        boolean active = Boolean.parseBoolean(booleanText);

        System.out.println("정수: " + number);
        // 정수: 250

        System.out.println("실수: " + decimal);
        // 실수: 3.14

        System.out.println("논리값: " + active);
        // 논리값: true
    }
}