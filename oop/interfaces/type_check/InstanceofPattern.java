package oop.interfaces.type_check;

// instanceof 패턴 매칭
// - instanceof 검사와 동시에 해당 타입의 변수를 만들 수 있다.
// - 별도의 강제 타입 변환 없이 자식 타입의 기능을 사용할 수 있다.
// - 기존의 instanceof + 형변환 코드를 간단하게 작성할 수 있다.

interface Media {
    void play();
}

class MusicMedia implements Media {

    @Override
    public void play() {
        System.out.println("음악을 재생합니다.");
    }

    void showArtist() {
        System.out.println("가수를 표시합니다.");
    }
}

public class InstanceofPattern {

    public static void main(String[] args) {
        Media media = new MusicMedia();

        // 타입 확인과 동시에 MusicMedia 타입의 변수 생성
        if (media instanceof MusicMedia music) {

            // 확인된 music 변수를 바로 사용할 수 있다.
            music.showArtist();
            // 가수를 표시합니다.
        }

        media.play();
        // 음악을 재생합니다.
    }
}