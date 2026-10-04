package library.multithreading.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Callable과 Future
// - Callable은 실행 결과를 반환할 수 있는 작업이다.
// - submit()으로 작업을 실행하면 Future 객체를 반환받는다.
// - Future의 get()을 이용하면 작업이 끝난 후 결과를 가져올 수 있다.
// - get()에 시간을 지정하면 최대 해당 시간 동안 결과를 기다린다.

public class ExecutorCallable {

    public static void main(String[] args) {
        // 하나의 스레드를 사용하는 스레드풀 생성
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            // 결과를 반환하는 작업 정의
            Callable<Integer> task = () -> {
                Thread.sleep(2000);
                return 100;
            };

            // 작업 실행 후 Future 객체를 반환받는다.
            Future<Integer> future = executor.submit(task);

            try {
                // 최대 5초 동안 작업 결과를 기다린다.
                Integer result = future.get(5, TimeUnit.SECONDS);

                System.out.println("결과: " + result);
                // 결과: 100

            } catch (InterruptedException e) {
                // 현재 스레드가 인터럽트된 경우
                Thread.currentThread().interrupt();

            } catch (ExecutionException e) {
                // 작업 내부에서 예외가 발생한 경우
                System.out.println("작업 실행 중 예외가 발생했습니다.");

            } catch (TimeoutException e) {
                // 지정된 시간 안에 작업이 끝나지 않은 경우
                System.out.println("작업 응답 시간이 초과되었습니다.");

                // 아직 실행 중인 작업에 취소를 요청한다.
                future.cancel(true);
            }

        } finally {
            // 새로운 작업을 받지 않는다.
            executor.shutdown();
        }
    }
}