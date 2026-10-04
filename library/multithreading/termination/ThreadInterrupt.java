package library.multithreading.termination;

// interrupt()로 스레드 안전 종료
// - interrupt()는 실행 중인 스레드에 중단 요청을 전달한다.
// - sleep(), wait(), join() 중이면 InterruptedException이 발생하며 대기 상태를 벗어난다.
// - 블로킹 메서드가 없는 긴 연산 작업 시에는 Thread.currentThread().isInterrupted()로 상태를 직접 확인해야 한다.

public class ThreadInterrupt {

    static class Worker implements Runnable {

        @Override
        public void run() {
            try {
                // 인터럽트 요청이 없으면 계속 작업한다.
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("작업 중");

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // InterruptedException이 발생하면 인터럽트 상태가 초기화된다.
                        // 종료 처리를 위해 다시 인터럽트 상태를 설정한다.
                        Thread.currentThread().interrupt();
                        System.out.println("인터럽트 발생 (sleep 상태 탈출 및 상태 복구 완료)");
                    }
                }
            } finally {
                // 종료 전에 필요한 정리 작업을 수행한다.
                System.out.println("자원 정리");
                System.out.println("실행 종료");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(new Worker(), "Worker");

        // 스레드 시작
        workerThread.start();

        // 일정 시간 동안 작업
        Thread.sleep(1000);

        // 스레드에 인터럽트 요청
        workerThread.interrupt();

        // 스레드가 종료될 때까지 기다린다.
        workerThread.join();
    }
}