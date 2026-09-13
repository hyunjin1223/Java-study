package oop.classes.access.other;

import oop.classes.access.AccessModifier;

// 다른 패키지에서 protected 멤버를 상속받아 사용하는 예제
public class AccessChild extends AccessModifier {

    void printProtected() {
        // 다른 패키지라도 상속 관계에서는 protected 멤버에 접근 가능
        System.out.println("protected 필드: " + protectedValue);

        protectedMethod();

        // public은 당연히 접근 가능
        System.out.println("public 필드: " + publicValue);
        publicMethod();
    }

    public static void main(String[] args) {
        AccessChild child = new AccessChild();

        child.printProtected();
    }
}