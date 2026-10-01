package library.java_base.wrapper_class;

// 포장 클래스
// - 기본 타입의 값을 객체로 감쌀 때 사용한다.
// - Integer, Double, Boolean 등의 클래스를 제공한다.
// - 컬렉션처럼 객체가 필요한 곳에서 기본 타입 값을 사용할 수 있다.

public class WrapperBasic {

    public static void main(String[] args) {

        // Boxing: int 값을 Integer 객체로 변환
        Integer number = 100;

        // Unboxing: Integer 객체의 값을 int로 변환
        int value = number;

        System.out.println("객체 값: " + number);
        // 객체 값: 100

        System.out.println("기본 타입 값: " + value);
        // 기본 타입 값: 100

        // 연산이 필요하면 객체가 자동으로 기본 타입으로 변환된다.
        int result = number + 50;

        System.out.println("연산 결과: " + result);
        // 연산 결과: 150
    }
}