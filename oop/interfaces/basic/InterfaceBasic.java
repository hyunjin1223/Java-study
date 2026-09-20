package oop.interfaces.basic;

// 인터페이스와 구현 객체 사용
// - 인터페이스도 참조 타입으로 사용할 수 있다.
// - 인터페이스 타입의 변수에는 해당 인터페이스를 구현한 객체를 대입할 수 있다.
// - 인터페이스 타입으로 메소드를 호출하면 실제 구현 객체의 메소드가 실행된다.

public class InterfaceBasic {

    public static void main(String[] args) {
        // 구현 클래스의 객체 생성
        Lamp lamp = new Lamp();

        lamp.turnOn();
        // 전등을 켭니다.

        lamp.turnOff();
        // 전등을 끕니다.

        // Lamp 객체를 인터페이스 타입으로 참조
        DeviceControl control = new Lamp();

        control.turnOn();
        // 전등을 켭니다.

        control.turnOff();
        // 전등을 끕니다.
    }
}