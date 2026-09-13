package oop.classes.access;

// 접근 제한자
// - 접근 제한자는 클래스, 필드, 메소드, 생성자에 접근할 수 있는 범위를 정한다.
// - public: 다른 패키지에서도 접근할 수 있다.
// - protected: 같은 패키지에서 접근할 수 있고, 다른 패키지에서는 상속받은 경우 접근할 수 있다.
// - default: 같은 패키지에서만 접근할 수 있다.
// - private: 같은 클래스 내부에서만 접근할 수 있다.
public class AccessModifier {

    public int publicValue = 10;
    protected int protectedValue = 20;
    int defaultValue = 30;
    private int privateValue = 40;

    // 클래스 내부에서는 모든 필드에 접근할 수 있다.
    public void printValues() {
        System.out.println("public: " + publicValue);
        System.out.println("protected: " + protectedValue);
        System.out.println("default: " + defaultValue);
        System.out.println("private: " + privateValue);
    }

    public void publicMethod() {
        System.out.println("public 메소드");
    }

    protected void protectedMethod() {
        System.out.println("protected 메소드");
    }

    void defaultMethod() {
        System.out.println("default 메소드");
    }

    private void privateMethod() {
        System.out.println("private 메소드");
    }

    // 같은 클래스 내부이므로 private 메소드 호출 가능
    public void callPrivateMethod() {
        privateMethod();
    }
}