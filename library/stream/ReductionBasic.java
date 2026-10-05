package library.stream;

import java.util.List;

// 스트림 사용자 정의 집계
// - reduce()는 여러 요소를 하나의 값으로 합친다.
// - 초기값을 지정하면 그 값을 시작점으로 사용한다.
// - 초기값이 없으면 결과가 Optional로 반환된다.

public class ReductionBasic {

    public static void main(String[] args) {

        List<Integer> scores = List.of(72, 85, 91, 68);

        // 초기값을 사용하여 총점 계산
        int total = scores.stream()
                .reduce(0, Integer::sum);

        // 초기값 없이 가장 큰 값 계산
        int max = scores.stream()
                .reduce(Integer::max)
                .orElse(0);

        // 문자열 요소를 하나의 문자열로 합치기
        // 문자열 결합에는 Collectors.joining()을 사용하는 것이 일반적이다.
        String result = List.of("Java", "Stream", "Lambda")
                .stream()
                .reduce((a, b) -> a + " -> " + b)
                .orElse("");

        System.out.println("총점: " + total);
        System.out.println("최고 점수: " + max);
        System.out.println("연결 결과: " + result);
    }
}