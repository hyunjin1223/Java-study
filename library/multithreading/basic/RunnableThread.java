package library.multithreading.basic;

// Runnable로 스레드 작업 정의
// - Runnable은 스레드가 실행할 작업을 정의하는 인터페이스다.
// - run() 메소드에 실제 작업 내용을 작성한다.
// - Runnable 객체를 Thread에 전달한 뒤 start()로 스레드를 실행한다.
// - 작업 내용과 Thread 객체를 분리해서 관리할 수 있다.
// - Thread를 상속할 수 없는 경우에도 Runnable을 사용해 작업을 정의할 수 있다.

public class RunnableThread {

    static class Task implements Runnable {

        @Override
        public void run() {

            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        Thread.currentThread().getName() + " 실행: " + i
                );

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {

        // Runnable 구현 객체 생성
        Runnable task = new Task();

        // Runnable을 Thread에 전달
        Thread thread = new Thread(task);

        // 작업 스레드 실행
        thread.start();

        // 메인 스레드도 동시에 작업
        for (int i = 1; i <= 5; i++) {
            System.out.println("main 실행: " + i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}