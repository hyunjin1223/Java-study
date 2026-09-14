package oop.classes.singleton;

public class SingletonLazyExample {
    public static void main(String[] args) {

        SingletonLazy a = SingletonLazy.getInstance();
        SingletonLazy b = SingletonLazy.getInstance();

        System.out.println(a == b);
        // true
    }
}