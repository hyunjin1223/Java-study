package library.stream;

import java.util.List;
import java.util.stream.IntStream;

// 병렬 스트림
// - parallelStream()은 컬렉션을 병렬 스트림으로 처리한다.
// - parallel()은 기존 스트림을 병렬 스트림으로 바꾼다.
// - 병렬로 처리할 수 있으므로 forEach()의 처리 순서는 보장되지 않는다.
// - 공유 자원을 변경하는 작업(Side-effect) 시 동기화 문제에 주의해야 한다.

public class ParallelBasic {

    public static void main(String[] args) {

        List<Integer> numbers = IntStream.rangeClosed(1, 12)
                .boxed()
                .toList();

        System.out.println("[parallelStream()]");

        numbers.parallelStream()
                .forEach(number ->
                        System.out.println(
                                number + " - " + Thread.currentThread().getName()));

        System.out.println();

        System.out.println("[parallel()]");

        numbers.stream()
                .parallel()
                .forEach(number ->
                        System.out.println(
                                number + " - " + Thread.currentThread().getName()));

        System.out.println();

        // 병렬 스트림을 이용한 합계 계산
        long sum = numbers.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();

        System.out.println("합계: " + sum);
    }
}