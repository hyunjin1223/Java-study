package oop.inheritance.protected_access;

// protected 접근 제한자
// - protected 멤버는 같은 패키지에서 접근할 수 있다.
// - 다른 패키지에서는 상속 관계일 때 접근할 수 있다.
// - 자식 클래스에서는 상속받은 protected 멤버를 사용할 수 있다.
// - protected 생성자도 같은 패키지와 자식 클래스에서 접근할 수 있다.

public class ProtectedBase {
    protected String name;
    protected int level;

    protected ProtectedBase(String name, int level) {
        this.name = name;
        this.level = level;
    }

    protected void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("레벨: " + level);
    }
}