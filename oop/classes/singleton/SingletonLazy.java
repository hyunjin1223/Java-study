package oop.classes.singleton;

// 지연 생성 싱글톤
// - 처음부터 객체를 만들지 않고 getInstance()가 처음 호출될 때 생성한다.
// - 객체가 실제로 필요할 때 생성한다는 점이 기본 방식과 다르다.
public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    // 처음 호출될 때 객체 생성
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }
}