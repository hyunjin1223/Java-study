package oop.interfaces.sealed_interface;

// 봉인된 인터페이스
// - sealed 인터페이스는 상속할 수 있는 대상을 제한할 수 있다.
// - permits 뒤에 직접 상속을 허용할 타입을 작성한다.
// - 허용된 자식 인터페이스는 sealed 또는 non-sealed로 선언해야 한다.

sealed interface AccessLevel
        permits UserAccess, AdminAccess {

    void check();
}

// AccessLevel의 상속을 여기서 끝내지 않고
// 다른 인터페이스가 다시 상속할 수 있도록 허용
non-sealed interface UserAccess extends AccessLevel {

}

// UserAccess가 non-sealed이므로 추가 상속 가능
interface BasicUserAccess extends UserAccess {

}

// AdminAccess 역시 상속 제한을 해제
non-sealed interface AdminAccess extends AccessLevel {

}

// AdminAccess를 다시 상속할 수 있음
interface SuperAdminAccess extends AdminAccess {

}