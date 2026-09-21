package oop.interfaces.multiple_interface;

// 여러 인터페이스 타입으로 객체 참조
// - 하나의 객체는 구현한 여러 인터페이스 타입으로 참조할 수 있다.
// - 어떤 인터페이스 타입으로 참조하느냐에 따라 사용할 수 있는 메소드가 달라진다.

interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

class MultiFunctionDevice implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("문서를 출력합니다.");
    }

    @Override
    public void scan() {
        System.out.println("문서를 스캔합니다.");
    }
}

public class InterfaceReference {

    public static void main(String[] args) {
        MultiFunctionDevice device = new MultiFunctionDevice();

        // Printable 타입으로 참조
        Printable printer = device;

        printer.print();
        // 문서를 출력합니다.

        // Scannable 타입으로 참조
        Scannable scanner = device;

        scanner.scan();
        // 문서를 스캔합니다.

        // 참조한 인터페이스에 없는 메소드는 사용할 수 없다.
        // printer.scan(); // 컴파일 에러
        // scanner.print(); // 컴파일 에러
    }
}