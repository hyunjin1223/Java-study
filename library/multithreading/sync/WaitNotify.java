package library.multithreading.sync;

// wait()와 notifyAll()로 스레드 실행 제어
// - wait()는 현재 스레드를 대기 상태로 만든다.
// - notifyAll()은 같은 객체에서 wait() 중인 스레드를 깨운다.
// - wait()와 notifyAll()은 synchronized 영역에서 사용해야 한다.
// - 작업 순서를 제어하기 위해 상태 조건을 함께 확인할 수 있다.

public class WaitNotify {

    static class WorkObject {

        // true면 A 차례, false면 B 차례
        private boolean turnA = true;

        public synchronized void workA() {

            // A 차례가 아니면 기다린다.
            while (!turnA) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println(
                    Thread.currentThread().getName() + ": 작업 실행"
            );

            // 다음은 B 차례
            turnA = false;

            // 대기 중인 스레드에게 알린다.
            notifyAll();
        }

        public synchronized void workB() {

            // B 차례가 아니면 기다린다.
            while (turnA) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println(
                    Thread.currentThread().getName() + ": 작업 실행"
            );

            // 다음은 A 차례
            turnA = true;

            // 대기 중인 스레드에게 알린다.
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        WorkObject work = new WorkObject();

        Thread threadA = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                work.workA();
            }

        }, "Thread-A");

        Thread threadB = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                work.workB();
            }

        }, "Thread-B");

        // 두 스레드 시작
        threadA.start();
        threadB.start();

        // 두 스레드의 작업이 끝날 때까지 기다린다.
        threadA.join();
        threadB.join();
    }
}