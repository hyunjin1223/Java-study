package oop.interfaces.inheritance;

// 다중 인터페이스 상속
// - 하나의 인터페이스는 여러 인터페이스를 동시에 상속할 수 있다.
// - extends 뒤에 상속할 인터페이스를 쉼표(,)로 구분한다.
// - 자식 인터페이스를 구현한 클래스는 상속받은 모든 메소드를 구현해야 한다.

interface ReadableData {
    void read();
}

interface WritableData {
    void write();
}

interface DocumentAccess extends ReadableData, WritableData {

    void open();
}

class DocumentFile implements DocumentAccess {

    @Override
    public void read() {
        System.out.println("문서 내용을 읽습니다.");
    }

    @Override
    public void write() {
        System.out.println("문서 내용을 저장합니다.");
    }

    @Override
    public void open() {
        System.out.println("문서를 엽니다.");
    }
}

public class MultipleInheritance {

    public static void main(String[] args) {
        DocumentFile file = new DocumentFile();

        file.open();
        // 문서를 엽니다.

        // 부모 인터페이스에서 상속받은 메소드
        file.read();
        // 문서 내용을 읽습니다.

        file.write();
        // 문서 내용을 저장합니다.
    }
}