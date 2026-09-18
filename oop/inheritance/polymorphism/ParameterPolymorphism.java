package oop.inheritance.polymorphism;

// 매개변수 다형성
// - 부모 타입을 매개변수로 사용하면 여러 자식 객체를 전달할 수 있다.
// - 자식 객체가 전달되면 부모 타입으로 자동 타입 변환되어 매개변수에 저장된다.
// - 전달된 실제 객체의 오버라이딩된 메소드가 실행된다.
// - 자식 클래스가 추가되어도 같은 메소드를 사용할 수 있다.

class Printer {
    void print() {
        System.out.println("문서를 출력합니다.");
    }
}

class BlackPrinter extends Printer {

    @Override
    void print() {
        System.out.println("흑백으로 출력합니다.");
    }
}

class ColorPrinter extends Printer {

    @Override
    void print() {
        System.out.println("컬러로 출력합니다.");
    }
}

public class ParameterPolymorphism {

    // 부모 타입을 매개변수로 받아 자식 객체도 전달할 수 있다.
    static void printDocument(Printer printer) {
        // 실제로 전달된 객체의 print()가 실행된다.
        printer.print();
    }

    public static void main(String[] args) {
        // BlackPrinter → Printer 자동 타입 변환
        printDocument(new BlackPrinter());
        // 흑백으로 출력합니다.

        // ColorPrinter → Printer 자동 타입 변환
        printDocument(new ColorPrinter());
        // 컬러로 출력합니다.
    }
}