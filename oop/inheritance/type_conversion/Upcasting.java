package oop.inheritance.type_conversion;

// 자동 타입 변환(Upcasting)
// - 자식 타입의 객체를 부모 타입 변수에 대입할 수 있다.
// - 자식 타입에서 부모 타입으로 변환하면 자동으로 처리된다.
// - 부모 타입으로 변환한 뒤에는 부모 클래스의 멤버를 사용할 수 있다.

class UpcastingVehicle {

    void move() {
        System.out.println("차량이 이동합니다.");
    }
}

class UpcastingCar extends UpcastingVehicle {

    void drive() {
        System.out.println("자동차가 주행합니다.");
    }
}

public class Upcasting {

    public static void main(String[] args) {
        UpcastingCar car = new UpcastingCar();

        // UpcastingCar → UpcastingVehicle 자동 타입 변환
        UpcastingVehicle vehicle = car;

        vehicle.move();
        // 차량이 이동합니다.

        // 부모 타입에서는 자식 전용 메소드를 직접 호출할 수 없다.
        // vehicle.drive(); // 컴파일 에러
    }
}