package library.stream;

import java.util.Arrays;

// 스트림 요소 조건 검사
// - allMatch()는 모든 요소가 조건을 만족하는지 검사한다.
// - anyMatch()는 하나 이상의 요소가 조건을 만족하는지 검사한다.
// - noneMatch()는 모든 요소가 조건을 만족하지 않는지 검사한다.

public class MatchingBasic {

    public static void main(String[] args) {

        int[] scores = {80, 90, 75, 88, 95};

        // 모든 점수가 70점 이상인지 확인
        boolean allPassed = Arrays.stream(scores)
                .allMatch(score -> score >= 70);

        // 90점 이상인 점수가 하나라도 있는지 확인
        boolean hasExcellent = Arrays.stream(scores)
                .anyMatch(score -> score >= 90);

        // 50점 미만인 점수가 없는지 확인
        boolean noLowScore = Arrays.stream(scores)
                .noneMatch(score -> score < 50);

        System.out.println("모두 70점 이상: " + allPassed);
        System.out.println("90점 이상 존재: " + hasExcellent);
        System.out.println("50점 미만 없음: " + noLowScore);
    }
}