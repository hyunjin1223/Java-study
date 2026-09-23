package oop.interfaces.type_conversion;

// 인터페이스 강제 타입 변환
// - 인터페이스 타입의 변수를 구현 클래스 타입으로 변환할 수 있다.
// - 구현 클래스 타입을 직접 작성해서 강제 타입 변환한다.
// - 실제 객체가 해당 구현 클래스인 경우에만 안전하게 사용할 수 있다.

interface DowncastControl {
    void turnOn();
}

class DowncastAirConditioner implements DowncastControl {

    @Override
    public void turnOn() {
        System.out.println("에어컨을 켭니다.");
    }

    void setTemperature(int temperature) {
        System.out.println("온도를 " + temperature + "도로 설정합니다.");
    }
}

public class Downcasting {

    public static void main(String[] args) {
        DowncastControl control = new DowncastAirConditioner();

        // 인터페이스 → 구현 클래스 강제 타입 변환
        DowncastAirConditioner airConditioner = (DowncastAirConditioner) control;

        airConditioner.turnOn();
        // 에어컨을 켭니다.

        // 구현 클래스에만 있는 메소드 사용
        airConditioner.setTemperature(24);
        // 온도를 24도로 설정합니다.
    }
}