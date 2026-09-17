package oop.inheritance.protected_access.other;

import oop.inheritance.protected_access.ProtectedBase;

// 다른 패키지이지만 상속 관계라면 protected 멤버에 접근할 수 있다.
public class ProtectedChild extends ProtectedBase {

    public ProtectedChild(String name, int level) {
        super(name, level);
    }

    void printUser() {
        // 상속받은 protected 필드 사용
        System.out.println("이름: " + name);
        System.out.println("레벨: " + level);

        // 상속받은 protected 메소드 사용
        printInfo();
    }

    public static void main(String[] args) {
        ProtectedChild user = new ProtectedChild("HyunJin", 10);

        user.printUser();

        // 이름: HyunJin
        // 레벨: 10
        // 이름: HyunJin
        // 레벨: 10
    }
}