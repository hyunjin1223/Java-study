package oop.interfaces.method;

// 인터페이스의 디폴트 메소드
// - 인터페이스에서 default 키워드를 사용하면 실행 내용을 가진 메소드를 만들 수 있다.
// - 구현 클래스에서 반드시 재정의할 필요는 없다.
// - 필요하면 구현 클래스에서 재정의해서 원하는 동작으로 바꿀 수 있다.
// - 디폴트 메소드는 구현 객체를 통해 호출한다.

interface NotificationService {

    void send();

    default void printStatus() {
        System.out.println("알림 기능을 사용할 수 있습니다.");
    }
}

class EmailService implements NotificationService {

    @Override
    public void send() {
        System.out.println("이메일을 전송합니다.");
    }

    // printStatus()는 디폴트 메소드를 그대로 사용
}

class SmsService implements NotificationService {

    @Override
    public void send() {
        System.out.println("문자 메시지를 전송합니다.");
    }

    // 디폴트 메소드를 필요한 내용으로 재정의
    @Override
    public void printStatus() {
        System.out.println("문자 알림 기능이 활성화되어 있습니다.");
    }
}

public class DefaultMethod {

    public static void main(String[] args) {
        NotificationService email = new EmailService();
        NotificationService sms = new SmsService();

        // 재정의하지 않은 디폴트 메소드
        email.printStatus();
        // 알림 기능을 사용할 수 있습니다.

        // 재정의한 디폴트 메소드
        sms.printStatus();
        // 문자 알림 기능이 활성화되어 있습니다.

        email.send();
        // 이메일을 전송합니다.

        sms.send();
        // 문자 메시지를 전송합니다.
    }
}