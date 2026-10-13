package oop.exception;

// try-catch-finally
// - try에는 예외가 발생할 수 있는 코드를 작성한다.
// - catch에서는 발생한 예외를 처리한다.
// - finally는 예외 발생 여부와 관계없이 일반적으로 실행된다.

public class TryCatchFinally {

    static void printLength(String text) {
        try {
            System.out.println("문자 수: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("문자열이 전달되지 않았습니다.");
            System.out.println("예외 종류: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("문자열 확인 작업 종료");
        }
    }

    public static void main(String[] args) {
        System.out.println("[첫 번째 확인]");
        printLength("Java Study");

        System.out.println();

        System.out.println("[두 번째 확인]");
        printLength(null);

        System.out.println();
        System.out.println("프로그램을 계속 실행합니다.");
    }
}