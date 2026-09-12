package oop.classes.modifier;

// 인스턴스 멤버와 this
// - 인스턴스 멤버는 객체를 생성해야 사용할 수 있는 필드와 메소드
// - 객체마다 자신의 인스턴스 멤버를 따로 가진다.
// - this는 현재 객체를 가리키며, 필드와 매개변수의 이름이 같을 때 주로 사용
public class InstanceMember {
    String name;
    int age;

    // 생성자를 통해 객체의 필드를 초기화
    InstanceMember(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 현재 객체의 나이를 변경
    void changeAge(int age) {
        this.age = age;
    }

    // 현재 객체의 정보를 출력
    void printInfo() {
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}