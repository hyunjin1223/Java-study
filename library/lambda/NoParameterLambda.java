package library.lambda;

// 매개변수가 없는 람다식
// - 추상 메소드에 매개변수가 없으면 빈 괄호를 사용한다.
// - 실행문이 하나라면 중괄호를 생략할 수 있다.
// - 실행문이 여러 개라면 중괄호를 사용한다.

public class NoParameterLambda {

    @FunctionalInterface
    interface Task {
        void run();
    }

    static void execute(Task task) {
        task.run();
    }

    public static void main(String[] args) {

        // 실행문이 여러 개인 경우
        execute(() -> {
            System.out.println("프로그램을 시작합니다.");
            System.out.println("작업을 실행합니다.");
        });

        System.out.println();

        // 실행문이 하나인 경우 중괄호 생략
        execute(() -> System.out.println("작업을 종료합니다."));
    }
}