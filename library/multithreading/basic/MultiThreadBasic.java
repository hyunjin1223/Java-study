package library.multithreading.basic;

// 멀티 스레드 기본 개념
// - 하나의 프로세스 안에서 여러 스레드가 독립적인 실행 흐름을 가질 수 있다.
// - main()을 실행하는 스레드를 메인 스레드라고 한다.
// - 여러 작업을 병렬 또는 동시에 처리하려면 작업 스레드를 추가할 수 있다.
// - start()를 호출하면 새로운 스레드에서 run()이 실행된다.
// - run()을 직접 호출하면 새로운 스레드가 생성되지 않고 현재 스레드에서 실행된다.
// - 멀티 스레드에서는 스레드의 실행 순서가 항상 일정하지 않을 수 있다.

public class MultiThreadBasic {

    public static void main(String[] args) {

        // 현재 코드를 실행하는 메인 스레드 확인
        Thread mainThread = Thread.currentThread();

        System.out.println("메인 스레드: " + mainThread.getName());

        // 별도의 작업 스레드 생성
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("작업 스레드: " + i);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 작업 스레드 시작
        worker.start();

        // 메인 스레드도 별도의 작업 수행
        for (int i = 1; i <= 3; i++) {
            System.out.println("메인 스레드: " + i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}