package oop.interfaces.basic;

// 인터페이스 구현
// - implements를 사용하여 인터페이스를 구현한다.
// - 구현 클래스는 인터페이스의 추상 메소드를 모두 구현해야 한다.

public class Lamp implements DeviceControl {

    @Override
    public void turnOn() {
        System.out.println("전등을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("전등을 끕니다.");
    }
}