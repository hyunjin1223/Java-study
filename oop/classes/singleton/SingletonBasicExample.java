package oop.classes.singleton;

// 싱글톤 객체 확인
public class SingletonBasicExample {
    public static void main(String[] args) {

        // new로 직접 생성할 수 없음
        // SingletonBasic a = new SingletonBasic(); // 컴파일 에러

        SingletonBasic user1 = SingletonBasic.getInstance();
        SingletonBasic user2 = SingletonBasic.getInstance();

        user1.printMessage();
        // 싱글톤 객체입니다.

        // 두 변수가 같은 객체를 참조하는지 확인
        System.out.println(user1 == user2);
        // true
    }
}