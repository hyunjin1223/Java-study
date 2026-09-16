package oop.inheritance.basic;

// 부모 생성자 호출
// - 자식 객체를 생성하면 부모 클래스의 생성자가 먼저 실행된다.
// - super(...)를 사용하면 부모 클래스의 생성자를 호출할 수 있다.
// - super(...)는 자식 생성자의 첫 번째 줄에 작성해야 한다.
// - 부모 생성자에 매개변수가 있으면 super(...)로 값을 전달해야 한다.

class Account {
    String owner;

    Account(String owner) {
        this.owner = owner;
        System.out.println("Account 생성자 실행");
    }
}

public class ParentConstructor extends Account {
    int balance;

    ParentConstructor(String owner, int balance) {
        super(owner);
        this.balance = balance;

        System.out.println("ParentConstructor 생성자 실행");
    }

    void printInfo() {
        System.out.println("소유자: " + owner);
        System.out.println("잔액: " + balance);
    }

    public static void main(String[] args) {
        ParentConstructor account =
                new ParentConstructor("HyunJin", 50000);
        // Account 생성자 실행
        // ParentConstructor 생성자 실행

        account.printInfo();
        // 소유자: HyunJin
        // 잔액: 50000
    }
}