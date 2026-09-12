package oop.classes.member;

// 생성자 오버로딩과 this()
// - 생성자는 매개변수의 개수나 타입 등이 다르면 여러 개 만들 수 있다.
// - 이렇게 하나의 클래스에 여러 생성자를 만드는 것을 생성자 오버로딩이라고 한다.
// - this(...)를 사용하면 같은 클래스의 다른 생성자를 호출할 수 있다.
// - 여러 생성자에서 같은 초기화 코드를 반복할 때 this(...)를 사용하면 중복을 줄일 수 있다.
// - this(...)는 반드시 생성자의 첫 번째 줄에 작성해야 한다.
public class ConstructorOverloading {
    String name;
    int age;
    String grade;

    // 아무 값도 전달하지 않으면 기본값으로 초기화
    ConstructorOverloading() {
        this("이름 없음", 0, "일반");
    }

    // 이름만 전달받고 나머지는 기본값을 사용
    ConstructorOverloading(String name) {
        this(name, 0, "일반");
    }

    // 모든 값을 전달받아 필드를 초기화
    ConstructorOverloading(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}