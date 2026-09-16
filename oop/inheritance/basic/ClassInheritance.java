package oop.inheritance.basic;

// 클래스 상속
// - extends 뒤에 부모 클래스를 작성하여 상속받는다.
// - 자식 객체는 부모 클래스의 필드와 메소드를 사용할 수 있다.
// - 자식 클래스는 자신의 필드와 메소드를 추가할 수 있다.

class Vehicle {
    String name;

    void move() {
        System.out.println(name + "가 이동합니다.");
    }
}

public class ClassInheritance extends Vehicle {
    int wheelCount;

    void printInfo() {
        System.out.println("차량: " + name);
        System.out.println("바퀴 수: " + wheelCount);
    }

    public static void main(String[] args) {
        ClassInheritance vehicle = new ClassInheritance();

        // 부모 클래스에서 물려받은 필드
        vehicle.name = "자동차";

        // 자식 클래스에서 추가한 필드
        vehicle.wheelCount = 4;

        // 부모 클래스에서 물려받은 메소드
        vehicle.move();
        // 자동차이가 이동합니다.

        // 자식 클래스에서 만든 메소드
        vehicle.printInfo();
        // 차량: 자동차
        // 바퀴 수: 4
    }
}