package library.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 스레드풀 기본
// - 작업마다 새로운 스레드를 생성하고 종료하는 비용을 줄이기 위해 스레드를 재사용한다.
// - newFixedThreadPool(n)은 최대 n개의 스레드로 작업을 처리한다.
// - 실행할 스레드가 부족하면 작업은 대기열에서 기다린다.

public class ThreadPoolBasic {

    public static void main(String[] args) {
        // 최대 3개의 스레드를 사용하는 스레드풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for (int i = 1; i <= 5; i++) {
                int taskNumber = i;

                // 작업을 스레드풀에 전달
                executor.execute(() -> {
                    String threadName = Thread.currentThread().getName();

                    System.out.println(
                            threadName + ": 작업 " + taskNumber + " 시작"
                    );

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // 인터럽트 상태를 다시 설정한다.
                        Thread.currentThread().interrupt();
                    }

                    System.out.println(
                            threadName + ": 작업 " + taskNumber + " 종료"
                    );
                });
            }
        } finally {
            // 새로운 작업을 받지 않고 기존 작업을 마무리한다.
            executor.shutdown();
        }
    }
}