package oop.classes.singleton;

public class SingletonHolderExample {
    public static void main(String[] args) {

        SingletonHolder a = SingletonHolder.getInstance();
        SingletonHolder b = SingletonHolder.getInstance();

        System.out.println(a == b);
        // true
    }
}