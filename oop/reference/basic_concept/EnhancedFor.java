package oop.reference.basic_concept;

// 향상된 for 문
// - 배열의 값을 하나씩 꺼내서 사용할 때 편리함
// - 인덱스를 직접 사용하지 않아도 됨
// - for (타입 변수 : 배열) 형태로 작성
public class EnhancedFor {
    public static void main(String[] args) {

        int[] scores = { 88, 76, 92, 85, 79 };

        // 1. 향상된 for 문으로 합계 계산
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        System.out.println("점수 합계: " + sum); // 점수 합계: 420

        // 2. 평균 계산
        double average = (double) sum / scores.length;

        System.out.println("점수 평균: " + average); // 점수 평균: 84.0
    }
}