package oop.inheritance.type_conversion;

// 강제 타입 변환(Downcasting)
// - 부모 타입의 변수를 자식 타입으로 변환할 때 직접 형변환해야 한다.
// - 실제 객체가 해당 자식 타입일 때만 안전하게 변환할 수 있다.
// - 변환한 뒤에는 자식 클래스의 멤버를 사용할 수 있다.

class DowncastingVehicle {

    void move() {
        System.out.println("차량이 이동합니다.");
    }
}

class DowncastingCar extends DowncastingVehicle {

    void drive() {
        System.out.println("자동차가 주행합니다.");
    }
}

public class Downcasting {

    public static void main(String[] args) {
        DowncastingVehicle vehicle = new DowncastingCar();

        // DowncastingVehicle → DowncastingCar 강제 타입 변환
        DowncastingCar car = (DowncastingCar) vehicle;

        car.move();
        // 차량이 이동합니다.

        car.drive();
        // 자동차가 주행합니다.
    }
}