package library.java_base.system_class;

// System 클래스의 콘솔 출력
// - System.out은 일반적인 내용을 출력한다.
// - System.err은 오류 내용을 출력할 때 사용한다.
// - 둘 다 콘솔에 출력하지만 용도가 다르다.

public class ConsoleOutput {

    public static void main(String[] args) {

        // 일반 내용 출력
        System.out.println("프로그램을 시작합니다.");
        // 프로그램을 시작합니다.

        // 오류 내용 출력
        System.err.println("오류가 발생했습니다.");
        // 오류가 발생했습니다.
    }
}