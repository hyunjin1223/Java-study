package oop.interfaces.polymorphism;

// 매개변수 다형성
// - 메소드의 매개변수를 인터페이스 타입으로 선언할 수 있다.
// - 해당 인터페이스를 구현한 여러 객체를 같은 메소드에 전달할 수 있다.
// - 전달된 실제 객체의 오버라이딩된 메소드가 실행된다.

interface Notification {
    void send();
}

class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("이메일을 전송합니다.");
    }
}

class SmsNotification implements Notification {

    @Override
    public void send() {
        System.out.println("문자 메시지를 전송합니다.");
    }
}

public class ParameterPolymorphism {

    // Notification을 구현한 객체를 매개값으로 받을 수 있다.
    static void sendNotification(Notification notification) {
        notification.send();
    }

    public static void main(String[] args) {
        sendNotification(new EmailNotification());
        // 이메일을 전송합니다.

        sendNotification(new SmsNotification());
        // 문자 메시지를 전송합니다.
    }
}