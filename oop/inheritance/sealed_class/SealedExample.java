package oop.inheritance.sealed_class;

// sealed 클래스 사용
// - permits에 지정된 클래스만 SealedClass를 직접 상속할 수 있다.
// - 부모 타입으로 자식 객체를 참조하면 다형성도 사용할 수 있다.

public class SealedExample {

    public static void main(String[] args) {
        // 자식 객체를 부모 타입으로 참조
        SealedClass user1 = new Admin();
        SealedClass user2 = new Guest();

        // 실제 객체에 따라 오버라이딩된 메소드가 실행된다.
        user1.printRole();
        // 관리자입니다.

        user2.printRole();
        // 방문자입니다.
    }
}

// permits에 지정되지 않은 클래스는 SealedClass를 상속할 수 없다.
// class Member extends SealedClass { } // 컴파일 에러