package oop.interfaces.multiple_interface;

// 다중 인터페이스 구현
// - 하나의 클래스는 여러 인터페이스를 동시에 구현할 수 있다.
// - implements 뒤에 인터페이스를 쉼표(,)로 구분한다.
// - 구현 클래스는 모든 인터페이스의 추상 메소드를 구현해야 한다.

interface Playable {
    void play();
}

interface Stoppable {
    void stop();
}

class MusicPlayer implements Playable, Stoppable {

    @Override
    public void play() {
        System.out.println("음악을 재생합니다.");
    }

    @Override
    public void stop() {
        System.out.println("음악을 정지합니다.");
    }
}

public class MultipleInterface {

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.play();
        // 음악을 재생합니다.

        player.stop();
        // 음악을 정지합니다.
    }
}