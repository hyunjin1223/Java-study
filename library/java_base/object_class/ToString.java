package library.java_base.object_class;

// toString()
// - Object의 toString()은 객체의 문자열 정보를 반환한다.
// - 기본 toString()은 클래스 이름과 해시 코드 형태로 반환된다.
// - 필요한 정보를 보여주도록 toString()을 재정의할 수 있다.
// - 객체를 문자열과 함께 출력할 때도 자동으로 호출된다.

class LaptopInfo {

    private String brand;
    private String model;

    LaptopInfo(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}

public class ToString {

    public static void main(String[] args) {
        LaptopInfo laptop =
                new LaptopInfo("LG", "Gram");

        // 재정의한 toString() 호출
        System.out.println(laptop.toString());
        // LG Gram

        // 객체를 출력해도 toString()이 자동으로 호출됨
        System.out.println(laptop);
        // LG Gram
    }
}