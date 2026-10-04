package library.multithreading.control;

// yield()로 실행 기회 양보
// - yield()는 현재 스레드가 다른 스레드에게 실행 기회를 양보하도록
//   스케줄러에 힌트를 제공한다.
// - 실제로 다른 스레드가 실행될지는 보장되지 않는다.

public class ThreadYield {

    static class Worker extends Thread {

        public Worker(String name) {
            setName(name);
        }

        @Override
        public void run() {

            for (int i = 1; i <= 10; i++) {

                System.out.println(
                        getName() + " 실행: " + i
                );

                // 다른 스레드에게 실행 기회를 양보한다.
                Thread.yield();
            }

            System.out.println(getName() + " 종료");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Worker worker1 = new Worker("Worker-1");
        Worker worker2 = new Worker("Worker-2");

        // 두 작업 스레드 시작
        worker1.start();
        worker2.start();

        // 두 스레드가 모두 끝날 때까지 기다린다.
        worker1.join();
        worker2.join();
    }
}