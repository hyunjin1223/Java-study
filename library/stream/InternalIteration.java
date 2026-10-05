package library.stream;

import java.util.Arrays;
import java.util.List;

// 내부 반복자
// - for문이나 Iterator는 개발자가 반복을 직접 제어하는 외부 반복 방식이다.
// - 스트림의 forEach()는 스트림 내부에서 요소를 반복 처리한다.
// - parallelStream()을 사용하면 여러 스레드에서 요소를 나누어 처리할 수 있다.
// - 병렬 처리에서는 출력 순서가 달라질 수 있다.

public class InternalIteration {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // 외부 반복
        for (Integer number : numbers) {
            System.out.println("for문: " + number);
        }

        System.out.println();

        // 내부 반복
        numbers.stream()
                .forEach(number ->
                        System.out.println("stream: " + number)
                );

        System.out.println();

        // 병렬 스트림
        numbers.parallelStream()
                .forEach(number ->
                        System.out.println(
                                number + " - " + Thread.currentThread().getName()
                        )
                );
    }
}