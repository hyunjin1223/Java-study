package oop.classes.singleton;

// enum을 이용한 싱글톤
// - enum의 상수는 하나만 존재하므로 싱글톤처럼 사용할 수 있다.
// - 별도의 private 생성자나 getInstance()를 직접 작성할 필요가 없다.
public enum SingletonEnum {

    INSTANCE;

    public void printMessage() {
        System.out.println("enum 싱글톤입니다.");
    }
}