package library.java_base.wrapper_class;

// 포장 객체의 값 비교
// - == 는 객체의 참조를 비교한다.
// - equals()는 객체가 가지고 있는 값을 비교한다.
// - 따라서 포장 객체의 값 비교에는 equals()를 사용하는 것이 안전하다.

public class WrapperCompare {

    public static void main(String[] args) {

        // 서로 다른 Integer 객체
        Integer first = 300;
        Integer second = 300;

        System.out.println("== 비교: " + (first == second));
        // == 비교: false

        System.out.println("equals() 비교: " + first.equals(second));
        // equals() 비교: true

        System.out.println();

        // 작은 정수는 자주 사용하는 값이라 같은 객체를 공유할 수 있다.
        Integer small1 = 10;
        Integer small2 = 10;

        System.out.println("작은 값 == 비교: " + (small1 == small2));
        // 작은 값 == 비교: true

        System.out.println("작은 값 equals(): " + small1.equals(small2));
        // 작은 값 equals(): true
    }
}