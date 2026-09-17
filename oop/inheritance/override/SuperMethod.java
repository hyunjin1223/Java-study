package oop.inheritance.override;

// super를 이용한 부모 메소드 호출
// - 자식 클래스에서 메소드를 오버라이딩하면 자식 메소드가 우선적으로 실행된다.
// - super.메소드()를 사용하면 오버라이딩된 부모 메소드를 직접 호출할 수 있다.
// - 부모의 기존 기능을 사용하면서 자식의 기능을 추가할 때 활용할 수 있다.

class BaseMessage {
    void send() {
        System.out.println("기본 알림을 보냅니다.");
    }
}

public class SuperMethod extends BaseMessage {

    @Override
    void send() {
        // 부모 메소드를 먼저 실행
        super.send();

        // 자식 클래스에서 기능 추가
        System.out.println("문자 알림을 추가로 보냅니다.");
    }

    public static void main(String[] args) {
        SuperMethod message = new SuperMethod();

        message.send();
        // 기본 알림을 보냅니다.
        // 문자 알림을 추가로 보냅니다.
    }
}