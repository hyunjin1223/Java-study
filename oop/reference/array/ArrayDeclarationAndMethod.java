package oop.reference;

// 배열(Array) 생성 2 - 선언과 대입 분리 및 메소드 인자 전달
// - 변수를 미리 선언한 후 나중에 값 목록을 대입할 때는 'new 타입[]' 생략 불가
// - 메소드의 매개변수로 배열 객체를 직접 전달할 때도 'new 타입[]' 필수
public class ArrayDeclarationAndMethod {
    public static void main(String[] args) {

        // 1. 배열 변수 선언
        int[] scores;

        // 2. 선언 후 대입 시 new int[] 명시 (없으면 컴파일 에러)
        scores = new int[] { 83, 90, 87 };

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += scores[i];
        }
        System.out.println("총합 : " + sum);                        // 260

        // 3. 메소드 호출 시 new int[]로 배열 객체 생성 후 전달
        printItem(new int[] { 95, 85, 90 });
    }

    // 배열을 전달받아 출력하는 메소드
    public static void printItem(int[] scores) {
        for (int i = 0; i < 3; i++) {
            System.out.println("score[" + i + "]: " + scores[i]);
        }
    }
}