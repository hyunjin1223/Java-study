package oop.classes.modifier;

// static 블록
// - static 블록은 클래스가 처음 로딩될 때 자동으로 한 번 실행된다.
// - 여러 줄의 코드가 필요한 정적 필드를 초기화할 때 사용할 수 있다.
public class StaticBlock {
    static String appName;
    static String version;

    // 클래스가 처음 사용될 때 실행
    static {
        appName = "MyApp";
        version = "1.0";

        System.out.println("static 블록 실행");
    }
}