package oop.inheritance.protected_access.other;

import oop.inheritance.protected_access.ProtectedBase;

// 다른 패키지이며 상속 관계도 없는 경우
public class OtherPackage {

    public static void main(String[] args) {

        // protected 생성자는 다른 패키지의 일반 클래스에서 호출할 수 없다.
        // ProtectedBase user = new ProtectedBase("HyunJin", 10); // 컴파일 에러

        System.out.println("ProtectedBase는 다른 패키지에서 직접 생성할 수 없습니다.");
        // ProtectedBase는 다른 패키지에서 직접 생성할 수 없습니다.
    }
}