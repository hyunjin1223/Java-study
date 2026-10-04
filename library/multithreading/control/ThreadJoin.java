package library.multithreading.control;

// join()으로 다른 스레드의 종료 기다리기
// - join()을 호출한 스레드는 대상 스레드가 끝날 때까지 기다린다.
// - 다른 스레드의 작업이 끝난 후 결과를 사용해야 할 때 활용할 수 있다.

public class ThreadJoin {

    static class SumTask implements Runnable {

        private int sum;

        @Override
        public void run() {

            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
        }

        public int getSum() {
            return sum;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SumTask task = new SumTask();
        Thread worker = new Thread(task);

        // 작업 스레드 시작
        worker.start();

        // 작업이 끝날 때까지 기다린다.
        worker.join();

        // 작업이 끝난 후 결과 사용
        System.out.println("1부터 100까지의 합: " + task.getSum());
        // 1부터 100까지의 합: 5050
    }
}