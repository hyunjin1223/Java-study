package oop.interfaces.inheritance;

// 인터페이스 상속
// - 인터페이스도 extends를 사용하여 다른 인터페이스를 상속할 수 있다.
// - 자식 인터페이스는 부모 인터페이스의 메소드를 물려받는다.
// - 자식 인터페이스를 구현한 클래스는 부모 인터페이스의 메소드까지 구현해야 한다.

interface ReadableFile {
    void read();
}

interface FileAccess extends ReadableFile {

    void open();
}

class TextFile implements FileAccess {

    @Override
    public void read() {
        System.out.println("파일을 읽습니다.");
    }

    @Override
    public void open() {
        System.out.println("파일을 엽니다.");
    }
}

public class InterfaceInheritance {

    public static void main(String[] args) {
        TextFile file = new TextFile();

        // 자식 인터페이스에 선언된 메소드
        file.open();
        // 파일을 엽니다.

        // 부모 인터페이스에서 물려받은 메소드
        file.read();
        // 파일을 읽습니다.
    }
}