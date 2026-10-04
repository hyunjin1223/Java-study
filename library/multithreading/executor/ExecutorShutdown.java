package library.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// ExecutorService 안전한 종료
// - shutdown()으로 새로운 작업을 받지 않는다.
// - awaitTermination()으로 기존 작업이 끝나는지 기다린다.
// - 시간이 지나도 종료되지 않으면 shutdownNow()로 종료를 요청한다.
// - shutdownNow()는 실행 중인 작업에 interrupt를 보내 종료를 요청하며,
//   실제 종료가 보장되는 것은 아니다.

public class ExecutorShutdown {

    public static void main(String[] args) {
        // 2개의 스레드를 사용하는 스레드풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            // 여러 작업을 스레드풀에 전달한다.
            for (int i = 1; i <= 4; i++) {
                int taskNumber = i;

                executor.execute(() -> {
                    System.out.println("작업 " + taskNumber + " 시작");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // shutdownNow()에 의해 인터럽트가 발생할 수 있다.
                        Thread.currentThread().interrupt();
                        System.out.println("작업 " + taskNumber + " 인터럽트 발생");
                    }

                    System.out.println("작업 " + taskNumber + " 종료");
                });
            }
        } finally {
            // 새로운 작업은 받지 않고 기존 작업은 계속 처리한다.
            executor.shutdown();
        }

        try {
            // 최대 10초 동안 모든 작업이 종료되기를 기다린다.
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {

                System.out.println("작업이 제한 시간 내에 종료되지 않았습니다.");

                // 실행 중인 작업에 interrupt를 보내 종료를 요청한다.
                executor.shutdownNow();

                // shutdownNow() 이후에도 종료되지 않는지 확인한다.
                if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                    System.out.println("스레드풀이 종료되지 않았습니다.");
                }

            } else {
                // 모든 작업이 정상적으로 종료된 경우
                System.out.println("모든 작업이 정상적으로 종료되었습니다.");
            }

        } catch (InterruptedException e) {
            // 현재 스레드가 인터럽트되면 종료를 요청한다.
            executor.shutdownNow();

            // 인터럽트 상태를 다시 설정한다.
            Thread.currentThread().interrupt();
        }
    }
}