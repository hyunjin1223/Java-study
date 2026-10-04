package library.multithreading.termination;

// 조건을 이용한 스레드 안전 종료
// - 실행 중인 스레드를 강제로 종료하는 stop()은 사용하지 않는다.
// - volatile 플래그로 다른 스레드에서 변경한 종료 상태를 바로 확인할 수 있다.
// - 스레드가 sleep() 등 대기 상태일 때 interrupt()를 함께 사용하면 즉시 종료할 수 있다.

public class ThreadSafeStop {

    static class Worker implements Runnable {
        private volatile boolean running = true;

        public void requestStop() {
            // 종료 플래그를 false로 변경한다.
            running = false;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            while (running) {
                System.out.println(threadName + ": 작업 중");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // 인터럽트 상태를 다시 설정하고 종료한다.
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            // 스레드 종료 전에 필요한 정리 작업을 수행할 수 있다.
            System.out.println(threadName + ": 자원 정리");
            System.out.println(threadName + ": 실행 종료");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker workerTask = new Worker();
        Thread workerThread = new Thread(workerTask, "Worker");

        // 스레드 시작
        workerThread.start();

        // 일정 시간 동안 작업
        Thread.sleep(2000);

        // 종료 플래그 변경
        workerTask.requestStop();

        // sleep() 중인 스레드를 깨운다.
        workerThread.interrupt();

        // 스레드가 완전히 종료될 때까지 기다린다.
        workerThread.join();
    }
}