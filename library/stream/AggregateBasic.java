package library.stream;

import java.util.Arrays;

// 스트림 기본 집계
// - count()는 요소 개수를 구한다.
// - max()와 min()은 최대값과 최소값을 구한다.
// - average()는 평균을 구한다.
// - sum()은 전체 합계를 구한다.

public class AggregateBasic {

    public static void main(String[] args) {

        int[] sales = {12000, 8500, 15000, 7000, 10500};

        long count = Arrays.stream(sales)
                .count();

        int max = Arrays.stream(sales)
                .max()
                .orElse(0);

        int min = Arrays.stream(sales)
                .min()
                .orElse(0);

        double average = Arrays.stream(sales)
                .average()
                .orElse(0.0);

        int sum = Arrays.stream(sales)
                .sum();

        System.out.println("판매 건수: " + count);
        System.out.println("최고 판매액: " + max);
        System.out.println("최저 판매액: " + min);
        System.out.println("평균 판매액: " + average);
        System.out.println("총 판매액: " + sum);
    }
}