package library.generic;

// 제한된 타입 파라미터
// - extends를 사용하면 타입 파라미터로 사용할 수 있는 타입을 제한할 수 있다.
// - T extends Number라면 Number와 그 하위 타입만 사용할 수 있다.
// - 제한된 타입 파라미터를 사용하면 상위 타입의 메소드를 사용할 수 있다.

public class BoundedType {

    // Number를 상속한 타입만 타입 파라미터로 사용할 수 있다.
    public static <T extends Number> boolean compare(
            T value1, T value2) {

        // Number의 doubleValue()를 사용해 값을 비교
        double number1 = value1.doubleValue();
        double number2 = value2.doubleValue();

        System.out.println(
                value1.getClass().getSimpleName()
                        + " vs "
                        + value2.getClass().getSimpleName()
        );

        return number1 == number2;
    }

    public static void main(String[] args) {

        // T가 Integer로 결정
        boolean result1 = compare(10, 20);
        System.out.println(result1);
        // false

        System.out.println();

        // T가 Double로 결정
        boolean result2 = compare(4.5, 4.5);
        System.out.println(result2);
        // true
    }
}