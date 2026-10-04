package library.multithreading.control;

// 스레드 상태 확인
// - Thread.State로 스레드의 현재 상태를 확인할 수 있다.
// - NEW: 스레드가 생성되었지만 아직 시작되지 않은 상태
// - RUNNABLE: 실행 중이거나 실행 준비가 된 상태
// - TIMED_WAITING: 일정 시간 동안 대기하는 상태
// - TERMINATED: 실행이 끝난 상태
// - Java에서는 실행 중인 스레드도 RUNNABLE 상태로 표현한다.

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {

            try {
                // 1초 동안 TIMED_WAITING 상태
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 스레드 생성 직후
        System.out.println("생성 직후: " + worker.getState());
        // NEW

        // 작업 스레드 시작
        worker.start();

        // 실제로 sleep 상태에 들어갈 때까지 기다린다.
        while (worker.getState() != Thread.State.TIMED_WAITING) {
            Thread.yield();
        }

        // sleep() 중
        System.out.println("sleep 중: " + worker.getState());
        // TIMED_WAITING

        // 작업 스레드가 종료될 때까지 기다린다.
        worker.join();

        // 실행 완료
        System.out.println("실행 종료: " + worker.getState());
        // TERMINATED
    }
}