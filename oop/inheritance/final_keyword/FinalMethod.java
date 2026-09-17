package oop.inheritance.final_keyword;

// final 메소드
// - final을 붙인 메소드는 자식 클래스에서 오버라이딩할 수 없다.
// - 클래스 전체가 아니라 특정 메소드만 변경하지 못하게 제한할 수 있다.
// - final이 아닌 메소드는 자식 클래스에서 오버라이딩할 수 있다.

class Payment {
    void pay() {
        System.out.println("결제합니다.");
    }

    final void cancel() {
        System.out.println("결제를 취소합니다.");
    }
}

public class FinalMethod extends Payment {

    // final이 아닌 메소드는 오버라이딩 가능
    @Override
    void pay() {
        System.out.println("온라인 결제를 합니다.");
    }

    // final 메소드는 오버라이딩할 수 없다.
    // @Override
    // void cancel() {
    //     System.out.println("결제를 바로 취소합니다.");
    // }


    public static void main(String[] args) {
        FinalMethod payment = new FinalMethod();

        payment.pay();
        // 온라인 결제를 합니다.

        payment.cancel();
        // 결제를 취소합니다.
    }
}