package library.java_base.system_class;

// 실행 시간 측정
// - currentTimeMillis()는 현재 시간을 밀리초 단위로 반환한다.
// - nanoTime()은 시간 차이를 정밀하게 측정할 때 사용할 수 있다.
// - 시작 시간과 종료 시간의 차이로 실행 시간을 구할 수 있다.

public class ExecutionTime {

    public static void main(String[] args) {

        long start = System.nanoTime();

        long sum = 0;

        // 1부터 1,000,000까지 더하기
        for (int i = 1; i <= 1_000_000; i++) {
            sum += i;
        }

        long end = System.nanoTime();

        System.out.println("합계: " + sum);
        // 합계: 500000500000

        System.out.println("실행 시간: "
                + (end - start) + " ns");
        // 실행 시간은 실행 환경에 따라 달라진다.
    }
}