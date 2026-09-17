package oop.inheritance.override;

// 메소드 재정의(오버라이딩)
// - 자식 클래스에서 부모 클래스의 메소드를 다시 작성할 수 있다.
// - 부모 메소드가 오버라이딩되면 자식 객체에서는 자식 메소드가 우선적으로 사용된다.
// - 부모 메소드는 일반적인 호출로는 실행되지 않고, super.메소드()로 직접 호출할 수 있다.
// - 메소드의 이름, 매개변수, 반환 타입을 부모 메소드와 맞춰야 한다.
// - @Override를 사용하면 메소드가 제대로 재정의되었는지 확인할 수 있다.

class Message {
    void send() {
        System.out.println("기본 알림을 보냅니다.");
    }
}

public class MethodOverride extends Message {

    // 부모의 send() 메소드를 재정의
    @Override
    void send() {
        System.out.println("문자 알림을 보냅니다.");
    }

    public static void main(String[] args) {
        MethodOverride message = new MethodOverride();

        // 부모 메소드 대신 오버라이딩한 자식 메소드가 실행
        message.send();
        // 문자 알림을 보냅니다.
    }
}