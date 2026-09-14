package oop.classes.singleton;

public class SingletonEnumExample {
    public static void main(String[] args) {

        SingletonEnum a = SingletonEnum.INSTANCE;
        SingletonEnum b = SingletonEnum.INSTANCE;

        a.printMessage();
        // enum 싱글톤입니다.

        System.out.println(a == b);
        // true
    }
}