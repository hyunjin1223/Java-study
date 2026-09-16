package oop.inheritance.basic;

// 상속
// - 부모 클래스의 기능을 자식 클래스가 물려받을 수 있다.
// - 자식 클래스는 extends를 사용하여 부모 클래스를 상속받는다.
// - 상속받은 메소드는 자식 클래스에서 그대로 사용할 수 있다.

class User {
    void login() {
        System.out.println("로그인했습니다.");
    }
}

public class InheritanceBasic extends User {

    public static void main(String[] args) {
        InheritanceBasic user = new InheritanceBasic();

        // 부모 클래스에서 물려받은 메소드
        user.login();
        // 로그인했습니다.
    }
}