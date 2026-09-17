package oop.inheritance.protected_access;

// 같은 패키지에서 protected 멤버 사용
public class SamePackage {

    public static void main(String[] args) {
        // 같은 패키지이므로 protected 생성자 호출 가능
        ProtectedBase user = new ProtectedBase("HyunJin", 10);

        // protected 필드 접근 가능
        System.out.println("이름: " + user.name);
        // 이름: HyunJin

        System.out.println("레벨: " + user.level);
        // 레벨: 10

        // protected 메소드 접근 가능
        user.printInfo();
        // 이름: HyunJin
        // 레벨: 10
    }
}