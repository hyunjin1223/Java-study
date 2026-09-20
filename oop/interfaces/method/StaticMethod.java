package oop.interfaces.method;

// 인터페이스의 정적 메소드
// - static 메소드는 구현 객체 없이 인터페이스 이름으로 호출할 수 있다.
// - 정적 메소드는 인터페이스에 속하므로 구현 클래스에서 오버라이딩할 수 없다.
// - 객체와 관계없이 사용할 공통 기능을 인터페이스에 제공할 때 사용할 수 있다.

interface NumberTool {

    static int max(int first, int second) {
        return first > second ? first : second;
    }

    static int min(int first, int second) {
        return first < second ? first : second;
    }
}

public class StaticMethod {

    public static void main(String[] args) {
        // 인터페이스 이름으로 정적 메소드 호출
        int max = NumberTool.max(15, 8);
        int min = NumberTool.min(15, 8);

        System.out.println("큰 수: " + max);
        // 큰 수: 15

        System.out.println("작은 수: " + min);
        // 작은 수: 8
    }
}