package library.lambda;

// 람다식 기본
// - 람다식은 함수형 인터페이스의 추상 메소드를 간단하게 표현할 수 있다.
// - 매개변수와 실행문으로 구성되며, 익명 구현 객체를 대신할 수 있다.
// - @FunctionalInterface는 추상 메소드가 하나인지 컴파일 시점에 확인해준다.

public class LambdaBasic {

    @FunctionalInterface
    interface MessageAction {
        void send(String message);
    }

    static void execute(MessageAction action) {
        action.send("새로운 메시지가 도착했습니다.");
    }

    public static void main(String[] args) {

        // 익명 구현 객체
        execute(new MessageAction() {
            @Override
            public void send(String message) {
                System.out.println(message);
            }
        });

        // 람다식으로 표현
        execute(message -> System.out.println(message));
        // 새로운 메시지가 도착했습니다.

        // 람다식의 기본 형태
        // (매개변수) -> { 실행문 }
    }
}