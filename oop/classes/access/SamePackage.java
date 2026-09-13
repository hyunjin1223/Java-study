package oop.classes.access;

// 같은 패키지에서 접근 제한자 확인
public class SamePackage {
    public static void main(String[] args) {
        AccessModifier example = new AccessModifier();

        // 같은 패키지에서는 public, protected, default 접근 가능
        System.out.println(example.publicValue);
        System.out.println(example.protectedValue);
        System.out.println(example.defaultValue);

        example.publicMethod();
        example.protectedMethod();
        example.defaultMethod();

        // private은 같은 클래스에서만 접근 가능
        // System.out.println(example.privateValue); // 컴파일 에러
        // example.privateMethod();                  // 컴파일 에러

        // public 메소드를 통해 클래스 내부의 private 메소드 실행
        example.callPrivateMethod();
    }
}