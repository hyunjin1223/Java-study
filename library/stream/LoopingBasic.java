package library.stream;

import java.util.Arrays;

// 스트림 요소 반복 처리
// - peek()은 중간 처리 과정에서 요소를 확인할 때 사용한다.
// - forEach()는 스트림의 최종 결과를 처리한다.
// - 중간 연산만 작성하고 최종 연산을 실행하지 않으면 스트림은 동작하지 않는다.

public class LoopingBasic {

    public static void main(String[] args) {

        int[] numbers = {3, 5, 8, 12, 17};

        // peek()은 최종 연산이 있어야 실행된다.
        int sum = Arrays.stream(numbers)
                .filter(number -> number % 3 == 0)
                .peek(number -> System.out.println("처리 중: " + number))
                .sum();

        System.out.println("합계: " + sum);

        System.out.println();

        // forEach()는 최종 연산
        Arrays.stream(numbers)
                .filter(number -> number > 7)
                .forEach(number ->
                        System.out.println("결과: " + number));
    }
}