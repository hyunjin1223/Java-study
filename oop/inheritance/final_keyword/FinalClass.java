package oop.inheritance.final_keyword;

// final 클래스
// - final을 붙인 클래스는 다른 클래스에서 상속할 수 없다.
// - 클래스 자체를 더 이상 확장하지 못하게 제한할 때 사용할 수 있다.
// - final 클래스의 객체를 생성하는 것은 가능하다.

public final class FinalClass {

    void printInfo() {
        System.out.println("FinalClass 객체입니다.");
    }

    public static void main(String[] args) {
        FinalClass example = new FinalClass();

        example.printInfo();
        // FinalClass 객체입니다.
    }
}

// final 클래스는 상속할 수 없다.
// class Child extends FinalClass { } // 컴파일 에러