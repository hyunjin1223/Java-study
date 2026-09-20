package oop.interfaces.method;

// 인터페이스의 private 메소드
// - private 메소드는 인터페이스 내부에서만 사용할 수 있다.
// - 외부나 구현 클래스에서 직접 호출할 수 없다.
// - 여러 디폴트 메소드에서 반복되는 코드를 하나의 private 메소드로 묶을 수 있다.
// - private static 메소드는 인터페이스의 static 메소드에서도 사용할 수 있다.

interface ReportService {

    default void startReport() {
        System.out.println("보고서를 준비합니다.");
        printLine();
    }

    default void endReport() {
        printLine();
        System.out.println("보고서를 저장합니다.");
    }

    // 디폴트 메소드에서 공통으로 사용하는 private 메소드
    private void printLine() {
        System.out.println("--------------------");
    }

    static void printTitle(String title) {
        printHeader();
        System.out.println(title);
    }

    // static 메소드에서 사용하는 private static 메소드
    private static void printHeader() {
        System.out.println("[Report]");
    }
}

class DailyReport implements ReportService {
}

public class PrivateMethod {

    public static void main(String[] args) {
        DailyReport report = new DailyReport();

        // 디폴트 메소드 호출
        report.startReport();
        // 보고서를 준비합니다.
        // --------------------

        report.endReport();
        // --------------------
        // 보고서를 저장합니다.

        // 인터페이스의 static 메소드 호출
        ReportService.printTitle("오늘의 업무 보고");
        // [Report]
        // 오늘의 업무 보고

        // private 메소드는 외부에서 직접 호출할 수 없다.
        // report.printLine();           // 컴파일 에러
        // ReportService.printHeader(); // 컴파일 에러
    }
}