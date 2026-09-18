package oop.inheritance.polymorphism;

// 다형성
// - 부모 타입 하나로 여러 자식 객체를 참조할 수 있다.
// - 부모 타입으로 참조하더라도 실제로 생성된 객체는 자식 객체이다.
// - 같은 메소드를 호출해도 실제 객체에 따라 다른 메소드가 실행될 수 있다.
// - 자식 클래스에서 오버라이딩한 메소드는 실제 객체의 메소드가 실행된다.

class Employee {
    void work() {
        System.out.println("업무를 시작합니다.");
    }
}

class Developer extends Employee {

    @Override
    void work() {
        System.out.println("프로그램을 개발합니다.");
    }
}

class Designer extends Employee {

    @Override
    void work() {
        System.out.println("화면을 디자인합니다.");
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        // 자식 객체를 부모 타입으로 참조
        Employee employee1 = new Developer();
        Employee employee2 = new Designer();

        // 실제 객체에 따라 오버라이딩된 메소드가 실행된다.
        employee1.work();
        // 프로그램을 개발합니다.

        employee2.work();
        // 화면을 디자인합니다.
    }
}