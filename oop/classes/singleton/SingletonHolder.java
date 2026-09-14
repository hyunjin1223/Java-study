package oop.classes.singleton;

// Holder 방식의 싱글톤
// - 실제 객체를 별도의 static 클래스에 저장한다.
// - getInstance()가 호출될 때 Holder 클래스가 사용되면서 객체가 생성된다.
// - 코드가 간단하면서 지연 생성이 가능하다.
public class SingletonHolder {

    private SingletonHolder() {
    }

    // 실제 객체는 필요할 때 생성
    private static class Holder {
        private static final SingletonHolder INSTANCE = new SingletonHolder();
    }

    // 유일한 객체 반환
    public static SingletonHolder getInstance() {
        return Holder.INSTANCE;
    }
}