package oop.interfaces.basic;

// 인터페이스의 상수 필드
// - 인터페이스에 선언한 필드는 자동으로 public static final이 된다.
// - 상수는 한 번 초기화하면 값을 변경할 수 없다.
// - 상수 이름은 보통 대문자와 언더바(_)를 사용한다.
// - 객체를 생성하지 않고 인터페이스 이름으로 바로 사용할 수 있다.

public interface ConstantField {

    int MAX_LEVEL = 50;
    int DEFAULT_LEVEL = 1;
    int MAX_EXP = 100000;

    public static void main(String[] args) {
        // 인터페이스 이름으로 상수 사용
        System.out.println("최대 레벨: " + ConstantField.MAX_LEVEL);
        // 최대 레벨: 50

        System.out.println("기본 레벨: " + ConstantField.DEFAULT_LEVEL);
        // 기본 레벨: 1

        System.out.println("최대 경험치: " + ConstantField.MAX_EXP);
        // 최대 경험치: 100000

        // 인터페이스의 상수는 값을 변경할 수 없다.
        // ConstantField.MAX_LEVEL = 100; // 컴파일 에러
    }
}