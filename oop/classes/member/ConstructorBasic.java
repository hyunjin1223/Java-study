package oop.classes.member;

// 생성자
// - 생성자는 객체가 생성될 때 호출되며, 주로 필드를 초기화하는 데 사용
// - 생성자의 이름은 클래스 이름과 같고 반환 타입을 작성하지 않는다.
// - 매개변수를 사용하면 객체를 생성할 때 필요한 값을 전달할 수 있다.
// - this를 사용하면 생성자의 매개변수와 필드의 이름이 같을 때 둘을 구분할 수 있다.
class ConstructorUser {
    String name;
    int age;

    // 전달받은 값을 객체의 필드에 저장
    ConstructorUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ConstructorBasic {
    public static void main(String[] args) {
        // 객체를 생성하면서 생성자에 값을 전달
        ConstructorUser user1 = new ConstructorUser("NENE", 20);
        ConstructorUser user2 = new ConstructorUser("YUKI", 21);

        System.out.println(user1.name + ", " + user1.age); // NENE, 20
        System.out.println(user2.name + ", " + user2.age); // YUKI, 21
    }
}