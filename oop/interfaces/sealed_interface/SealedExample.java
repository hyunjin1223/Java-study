package oop.interfaces.sealed_interface;

// 봉인된 인터페이스 사용
// - AccessLevel은 permits에 지정된 타입만 직접 상속할 수 있다.
// - non-sealed 인터페이스는 다시 다른 인터페이스가 상속할 수 있다.

public class SealedExample {

    public static void main(String[] args) {
        AccessLevel user = new BasicUserPermission();
        AccessLevel admin = new AdminPermission();
        AccessLevel superAdmin = new SuperAdminPermission();

        user.check();
        // 기본 사용자 권한을 확인합니다.

        admin.check();
        // 관리자 권한을 확인합니다.

        superAdmin.check();
        // 최고 관리자 권한을 확인합니다.
    }
}

class BasicUserPermission implements BasicUserAccess {

    @Override
    public void check() {
        System.out.println("기본 사용자 권한을 확인합니다.");
    }
}

class AdminPermission implements AdminAccess {

    @Override
    public void check() {
        System.out.println("관리자 권한을 확인합니다.");
    }
}

class SuperAdminPermission implements SuperAdminAccess {

    @Override
    public void check() {
        System.out.println("최고 관리자 권한을 확인합니다.");
    }
}

// AccessLevel에서 직접 허용하지 않은 인터페이스는 상속할 수 없다.
// interface GuestAccess extends AccessLevel { } // 컴파일 에러