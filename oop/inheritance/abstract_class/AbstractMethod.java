package oop.inheritance.abstract_class;

// 추상 메소드
// - abstract 메소드는 선언만 하고 메소드의 내용을 작성하지 않는다.
// - 추상 메소드를 가진 클래스는 abstract 클래스로 선언해야 한다.
// - 일반 자식 클래스는 추상 메소드를 반드시 구현해야 한다.
// - 자식 클래스마다 같은 메소드를 서로 다르게 구현할 수 있다.

abstract class Notification {

    abstract void send();
}

class EmailNotification extends Notification {

    @Override
    void send() {
        System.out.println("이메일을 보냅니다.");
    }
}

class SmsNotification extends Notification {

    @Override
    void send() {
        System.out.println("문자 메시지를 보냅니다.");
    }
}

public class AbstractMethod {

    public static void main(String[] args) {
        Notification email = new EmailNotification();
        Notification sms = new SmsNotification();

        email.send();
        // 이메일을 보냅니다.

        sms.send();
        // 문자 메시지를 보냅니다.
    }
}