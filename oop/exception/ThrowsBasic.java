package oop.exception;

// throws를 이용한 예외 전달
// - 메소드에서 직접 처리하지 않을 예외는 throws로 선언할 수 있다.
// - 예외를 전달받은 호출 지점에서 처리해야 한다.

public class ThrowsBasic {

    static Class<?> loadClass(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    public static void main(String[] args) {
        try {
            Class<?> type = loadClass("java.util.ArrayList");
            System.out.println("클래스 확인: " + type.getSimpleName());

            loadClass("sample.missing.UnknownType");

        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 수 없습니다: " + e.getMessage());
        }

        System.out.println("다음 작업을 실행합니다.");
    }
}