package oop.interfaces.basic;

// 인터페이스 선언
// - interface 키워드를 사용하여 인터페이스를 선언한다.
// - 인터페이스는 클래스가 구현해야 할 기능을 정의한다.
// - 추상 메소드는 메소드의 형태만 작성하고 내용을 작성하지 않는다.
// - 구현 클래스는 인터페이스에 선언된 추상 메소드를 구현해야 한다.

public interface DeviceControl {

    // 구현 클래스에서 반드시 구현해야 하는 메소드
    void turnOn();

    void turnOff();
}