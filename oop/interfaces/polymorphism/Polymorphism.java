package oop.interfaces.polymorphism;

// 다형성
// - 인터페이스 타입으로 여러 구현 객체를 참조할 수 있다.
// - 같은 메소드를 호출해도 실제 객체에 따라 실행 결과가 달라질 수 있다.
// - 구현 객체를 바꿔도 같은 인터페이스를 통해 사용할 수 있다.

interface Payment {
    void pay(int amount);
}

class CardPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("카드로 " + amount + "원 결제합니다.");
    }
}

class CashPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("현금으로 " + amount + "원 결제합니다.");
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        // 같은 인터페이스 타입으로 서로 다른 객체를 참조
        Payment payment1 = new CardPayment();
        Payment payment2 = new CashPayment();

        // 같은 메소드를 호출하지만 실제 객체에 따라 결과가 다르다.
        payment1.pay(15000);
        // 카드로 15000원 결제합니다.

        payment2.pay(15000);
        // 현금으로 15000원 결제합니다.
    }
}