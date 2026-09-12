package oop.classes.member;

// 필드
// - 필드는 클래스 안에서 선언하는 변수로, 객체의 데이터를 저장
// - 객체마다 자신의 필드값을 따로 가지고 있기 때문에 서로 다른 값을 저장할 수 있다.
// - 필드에 초기값을 지정하지 않으면 자료형에 따라 기본값으로 자동 초기화된다.
// - 객체를 생성한 뒤에는 도트(.) 연산자로 필드에 접근할 수 있다.
class User {
    String name;       // 참조 타입의 기본값: null
    int age;           // int의 기본값: 0
    boolean active;    // boolean의 기본값: false
}

public class FieldBasic {
    public static void main(String[] args) {
        User user = new User();

        // 아직 값을 넣지 않았기 때문에 각 자료형의 기본값이 출력
        System.out.println("이름: " + user.name);       // 이름: null
        System.out.println("나이: " + user.age);        // 나이: 0
        System.out.println("활동 여부: " + user.active); // 활동 여부: false

        // 객체의 필드에 값을 직접 저장
        user.name = "HyunJin";
        user.age = 20;
        user.active = true;

        System.out.println("이름: " + user.name);       // 이름: HyunJin
        System.out.println("나이: " + user.age);        // 나이: 20
        System.out.println("활동 여부: " + user.active); // 활동 여부: true
    }
}