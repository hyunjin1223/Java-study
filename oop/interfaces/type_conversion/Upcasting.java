package oop.interfaces.type_conversion;

// 인터페이스 자동 타입 변환
// - 인터페이스를 구현한 객체는 해당 인터페이스 타입으로 자동 변환할 수 있다.
// - 인터페이스 타입으로 참조하면 인터페이스에 선언된 메소드를 사용할 수 있다.
// - 구현 클래스에만 있는 메소드는 직접 사용할 수 없다.

interface UpcastControl {
    void turnOn();
}

class UpcastAirConditioner implements UpcastControl {

    @Override
    public void turnOn() {
        System.out.println("에어컨을 켭니다.");
    }

    void setTemperature(int temperature) {
        System.out.println("온도를 " + temperature + "도로 설정합니다.");
    }
}

public class Upcasting {

    public static void main(String[] args) {
        UpcastAirConditioner airConditioner = new UpcastAirConditioner();

        // 구현 클래스 → 인터페이스 자동 타입 변환
        UpcastControl control = airConditioner;

        // 인터페이스에 선언된 메소드 사용
        control.turnOn();
        // 에어컨을 켭니다.

        // 구현 클래스에만 있는 메소드는 사용할 수 없다.
        // control.setTemperature(24); // 컴파일 에러
    }
}