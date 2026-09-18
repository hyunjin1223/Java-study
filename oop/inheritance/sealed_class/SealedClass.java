package oop.inheritance.sealed_class;

// 봉인된 클래스
// - sealed를 사용하면 직접 상속할 수 있는 클래스를 제한할 수 있다.
// - permits 뒤에 상속을 허용할 클래스를 지정한다.
// - permits에 지정되지 않은 클래스가 상속하려 하면 컴파일 에러가 발생한다.
// - 허용된 자식 클래스는 final, sealed, non-sealed 중 하나로 선언해야 한다.

public sealed class SealedClass permits Admin, Guest {

    void printRole() {
        System.out.println("사용자입니다.");
    }
}

final class Admin extends SealedClass {

    @Override
    void printRole() {
        System.out.println("관리자입니다.");
    }
}

final class Guest extends SealedClass {

    @Override
    void printRole() {
        System.out.println("방문자입니다.");
    }
}