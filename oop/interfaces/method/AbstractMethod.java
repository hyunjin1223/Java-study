package oop.interfaces.method;

// 인터페이스의 추상 메소드
// - 추상 메소드는 메소드의 형태만 선언하고 실행 내용은 작성하지 않는다.
// - 인터페이스의 추상 메소드는 기본적으로 public abstract 특성을 가진다.
// - 인터페이스를 구현한 일반 클래스는 추상 메소드를 반드시 구현해야 한다.
// - 같은 추상 메소드를 구현하더라도 클래스마다 다른 동작을 작성할 수 있다.

interface PaymentMethod {

    // 메소드의 이름, 매개변수, 반환 타입만 선언
    void pay(int amount);
}

class CardPayment implements PaymentMethod {

    // 인터페이스의 추상 메소드 구현
    @Override
    public void pay(int amount) {
        System.out.println("카드로 " + amount + "원 결제합니다.");
    }
}

class CashPayment implements PaymentMethod {

    // 같은 추상 메소드를 현금 결제 방식으로 구현
    @Override
    public void pay(int amount) {
        System.out.println("현금으로 " + amount + "원 결제합니다.");
    }
}

public class AbstractMethod {

    public static void main(String[] args) {
        // 구현 객체를 인터페이스 타입으로 참조
        PaymentMethod card = new CardPayment();
        PaymentMethod cash = new CashPayment();

        // 실제 구현 객체의 pay() 메소드가 실행된다.
        card.pay(15000);
        // 카드로 15000원 결제합니다.

        cash.pay(8000);
        // 현금으로 8000원 결제합니다.
    }
}