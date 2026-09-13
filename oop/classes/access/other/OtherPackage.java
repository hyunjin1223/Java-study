package oop.classes.access.other;

import oop.classes.access.AccessModifier;

// 다른 패키지에서 접근 제한자 확인
public class OtherPackage {
    public static void main(String[] args) {
        AccessModifier example = new AccessModifier();

        // public은 다른 패키지에서도 접근 가능
        System.out.println(example.publicValue);
        example.publicMethod();

        // protected는 일반적인 다른 패키지 클래스에서는 접근할 수 없다.
        // System.out.println(example.protectedValue); // 컴파일 에러
        // example.protectedMethod();                  // 컴파일 에러

        // default는 다른 패키지에서 접근할 수 없다.
        // System.out.println(example.defaultValue); // 컴파일 에러
        // example.defaultMethod();                 // 컴파일 에러

        // private도 다른 패키지에서 접근할 수 없다.
        // System.out.println(example.privateValue); // 컴파일 에러
        // example.privateMethod();                  // 컴파일 에러
    }
}