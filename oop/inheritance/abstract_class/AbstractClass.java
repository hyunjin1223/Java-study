package oop.inheritance.abstract_class;

// 추상 클래스
// - abstract를 붙인 클래스는 직접 객체를 생성할 수 없다.
// - 공통으로 사용할 필드와 일반 메소드를 자식 클래스에 제공할 수 있다.
// - 여러 자식 클래스에서 공통으로 사용할 내용을 부모 클래스에 작성할 수 있다.

abstract class User {
    String name;

    User(String name) {
        this.name = name;
    }

    void login() {
        System.out.println(name + "이(가) 로그인했습니다.");
    }
}

class Member extends User {

    Member(String name) {
        super(name);
    }
}

public class AbstractClass {

    public static void main(String[] args) {
        // 추상 클래스를 직접 생성할 수 없기 때문에 자식 클래스를 사용
        Member user = new Member("HyunJin");

        // User에서 물려받은 일반 메소드
        user.login();
        // HyunJin이(가) 로그인했습니다.
    }
}

// User user = new User("HyunJin"); // 컴파일 에러