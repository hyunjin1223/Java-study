package oop.classes.modifier;

// static에서 인스턴스 멤버 사용 제한
// - static 메소드는 객체 없이 호출할 수 있기 때문에 특정 객체의 인스턴스 멤버를 바로 사용할 수 없다.
// - static 메소드에서는 인스턴스 필드와 인스턴스 메소드를 직접 사용할 수 없다.
// - this 역시 현재 객체를 가리키기 때문에 static 메소드에서는 사용할 수 없다.
// - 객체를 직접 생성하면 참조 변수를 통해 인스턴스 멤버에 접근할 수 있다.
public class StaticRestriction {
    int instanceValue = 10;
    static int staticValue = 20;

    void printInstanceValue() {
        System.out.println("인스턴스 값: " + instanceValue);
    }

    static void printStaticValue() {
        // System.out.println(instanceValue); // 사용 불가
        // printInstanceValue();              // 사용 불가
        // System.out.println(this.instanceValue); // 사용 불가

        // 객체를 생성하면 참조 변수로 인스턴스 멤버에 접근할 수 있다.
        StaticRestriction example = new StaticRestriction();

        System.out.println("인스턴스 값: " + example.instanceValue);
        // 인스턴스 값: 10

        example.printInstanceValue();
        // 인스턴스 값: 10

        System.out.println("static 값: " + staticValue);
        // static 값: 20
    }
}