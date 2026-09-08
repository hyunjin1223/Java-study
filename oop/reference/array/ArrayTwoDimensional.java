package oop.reference;

// 2차원 배열
// - 행과 열로 이루어진 배열
// - 배열 안에 배열이 들어있는 형태
// - length로 행과 각 행의 열 개수를 확인할 수 있음
public class ArrayTwoDimensional {
    public static void main(String[] args) {

        // 1. 값 목록으로 2차원 배열 생성
        int[][] scores = {
                { 85, 92, 78 },
                { 90, 81, 95 }
        };

        // 행과 열의 개수 확인
        System.out.println("행의 개수: " + scores.length);             // 행의 개수: 2
        System.out.println("첫 번째 행의 열 개수: " + scores[0].length); // 첫 번째 행의 열 개수: 3

        // 2. 행마다 다른 길이의 배열 생성
        int[][] mathScores = new int[2][];
        mathScores[0] = new int[3];
        mathScores[1] = new int[2];

        mathScores[0][0] = 88;
        mathScores[0][1] = 91;
        mathScores[0][2] = 84;

        mathScores[1][0] = 76;
        mathScores[1][1] = 93;

        // 3. 중첩 for 문으로 전체 값 계산
        int totalSum = 0;
        int totalCount = 0;

        for (int i = 0; i < mathScores.length; i++) {
            totalCount += mathScores[i].length;

            for (int k = 0; k < mathScores[i].length; k++) {
                totalSum += mathScores[i][k];
            }
        }

        System.out.println("수학 점수 총합: " + totalSum);              // 수학 점수 총합: 432
        System.out.println("수학 점수 평균: " + (double) totalSum / totalCount); // 수학 점수 평균: 86.4
    }
}