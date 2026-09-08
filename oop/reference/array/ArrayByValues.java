package oop.reference;

// 배열(Array) 생성 1 - 값 목록으로 생성
// - 연속된 메모리 공간에 같은 타입의 데이터들을 나열하는 참조 타입
// - 생성과 동시에 중괄호({})로 값 목록을 대입
public class ArrayByValues {
    public static void main(String[] args) {

        // 1. String 배열 생성 및 인덱스(0부터 시작) 접근
        String[] season = { "Spring", "Summer", "Fall", "Winter" };

        System.out.println("season[0] : " + season[0]);             // "Spring"
        System.out.println("season[1] : " + season[1]);             // "Summer"

        // 2. 특정 인덱스의 항목 값 변경
        season[1] = "여름";                                          // "Summer" -> "여름" 변경
        System.out.println("season[1] : " + season[1]);             // "여름"

        // 3. int 배열 생성 및 총합/평균 계산
        int[] scores = { 83, 90, 87 };

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += scores[i];                                       // scores[0] + scores[1] + scores[2]
        }
        System.out.println("총합 : " + sum);                          // 260

        double avg = (double) sum / 3;                              // 실수 연산을 위한 double 강제 형변환
        System.out.println("평균 : " + avg);                        // 86.66666666666667
    }
}