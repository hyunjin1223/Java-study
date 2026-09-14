package oop.classes.singleton;

// 싱글톤 패턴
// - 싱글톤은 클래스의 인스턴스를 하나만 만들어 사용하는 패턴이다.
// - 생성자를 private으로 만들면 외부에서 new로 객체를 만들 수 없다.
// - static 필드에 하나의 객체를 저장하고, static 메소드로 그 객체를 반환한다.
// - 따라서 어디에서 getInstance()를 호출해도 같은 객체를 받게 된다.
public class SingletonBasic {

    // 클래스가 로딩될 때 객체를 하나 생성
    private static final SingletonBasic instance = new SingletonBasic();

    // 외부에서 객체를 직접 생성하지 못하도록 private 생성자 사용
    private SingletonBasic() {
    }

    // 유일한 객체를 반환
    public static SingletonBasic getInstance() {
        return instance;
    }

    public void printMessage() {
        System.out.println("싱글톤 객체입니다.");
    }
}