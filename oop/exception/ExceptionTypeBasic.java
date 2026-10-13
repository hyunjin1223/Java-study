package oop.exception;

// 예외의 종류
// - Throwable 아래에는 Exception과 Error가 있다.
// - 일반 예외(Checked Exception)는 예외 처리를 하거나 throws로 전달해야 한다.
// - 실행 예외(Unchecked Exception)는 컴파일 단계에서 예외 처리를 강제하지 않는다.

public class ExceptionTypeBasic {

    public static void main(String[] args) {

        // InterruptedException: 일반 예외
        try {
            Thread.sleep(100);
            System.out.println("잠시 대기했습니다.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("대기 중 인터럽트가 발생했습니다.");
        }

        // NumberFormatException: 실행 예외
        try {
            int count = Integer.parseInt("three");
            System.out.println("개수: " + count);
        } catch (NumberFormatException e) {
            System.out.println("문자열을 정수로 변환할 수 없습니다.");
        }
    }
}