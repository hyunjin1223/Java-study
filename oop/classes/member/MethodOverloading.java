package oop.classes.member;

// 메소드 오버로딩
// - 하나의 클래스에서 같은 이름의 메소드를 여러 개 만들 수 있다.
// - 단, 매개변수의 개수나 타입, 순서가 달라야 한다.
// - 반환 타입만 다르게 만드는 것은 오버로딩으로 사용할 수 없다.
// - 메소드를 호출하면 전달한 인자에 맞는 메소드가 선택된다.
public class MethodOverloading {

    // 이름만 전달받는 메소드
    void printInfo(String name) {
        System.out.println("이름: " + name);
    }

    // 이름과 나이를 전달받는 메소드
    void printInfo(String name, int age) {
        System.out.println("이름: " + name + ", 나이: " + age);
    }

    // 이름, 나이, 등급을 전달받는 메소드
    void printInfo(String name, int age, String grade) {
        System.out.println("이름: " + name + ", 나이: " + age + ", 등급: " + grade);
    }

    public static void main(String[] args) {
        MethodOverloading example = new MethodOverloading();

        // 전달한 인자의 개수에 따라 다른 메소드가 호출된다.
        example.printInfo("HyunJin");
        // 이름: HyunJin

        example.printInfo("HyunJin", 20);
        // 이름: HyunJin, 나이: 20

        example.printInfo("HyunJin", 20, "VIP");
        // 이름: HyunJin, 나이: 20, 등급: VIP
    }
}