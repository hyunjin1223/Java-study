package library.multithreading.sync;

// synchronized로 공유 데이터 보호
// - 여러 스레드가 같은 데이터를 변경할 때 동기화가 필요하다.
// - synchronized 메소드는 메소드 전체를 동기화한다.
// - synchronized 블록은 필요한 코드 영역만 동기화할 수 있다.
// - 같은 객체의 synchronized 영역은 하나의 락을 공유한다.

public class SynchronizedCounter {

    static class Counter {

        private int value;

        // 메소드 전체를 동기화
        public synchronized void increment() {
            value++;
        }

        // 필요한 부분만 동기화
        public void incrementBlock() {

            synchronized (this) {
                value++;
            }
        }

        // 읽기 작업도 synchronized로 보호
        public synchronized int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                counter.incrementBlock();
            }
        });

        // 두 스레드 시작
        thread1.start();
        thread2.start();

        // 두 스레드의 작업이 끝날 때까지 기다린다.
        thread1.join();
        thread2.join();

        System.out.println("최종 값: " + counter.getValue());
        // 최종 값: 2000
    }
}