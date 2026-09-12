package oop.classes.modifier;

// static 멤버
// - static이 붙은 필드와 메소드는 객체를 만들지 않아도 사용할 수 있다.
// - 여러 객체가 하나의 값을 함께 사용해야 할 때 static 필드를 사용한다.
// - static 메소드는 클래스 이름으로 호출할 수 있다.
public class StaticMember {
    // 모든 객체가 함께 사용하는 필드
    static int userCount = 0;

    // 객체가 생성될 때마다 사용자 수 증가
    StaticMember() {
        userCount++;
    }

    // static 메소드는 객체와 관계없이 동작
    static int add(int x, int y) {
        return x + y;
    }
}