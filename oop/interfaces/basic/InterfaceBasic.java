package oop.interfaces.basic;

// 인터페이스 선언
// - interface 키워드로 선언한다.
// - 인터페이스는 구현 클래스가 따라야 할 기능을 정의한다.
// - 추상 메소드는 메소드의 형태만 작성하고 실행 내용은 작성하지 않는다.
interface DeviceControl {

    void turnOn();
    void turnOff();
}

// 인터페이스 구현
// - implements를 사용하여 인터페이스를 구현한다.
// - 구현 클래스는 인터페이스의 추상 메소드를 모두 구현해야 한다.
class Lamp implements DeviceControl {

    @Override
    public void turnOn() {
        System.out.println("전등을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("전등을 끕니다.");
    }
}

// 인터페이스와 구현 객체 사용
// - 인터페이스 타입의 변수에는 구현 객체를 대입할 수 있다.
// - 인터페이스 타입으로 선언된 메소드를 호출할 수 있다.
public class InterfaceBasic {

    public static void main(String[] args) {
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