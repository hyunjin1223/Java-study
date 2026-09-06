package basic.variables_and_types;

// boolean 타입 및 조건식
public class BooleanType {
    public static void main(String[] args) {

        boolean isReady = true;

        if (isReady) {
            System.out.println("준비가 완료되었습니다.");
        } else {
            System.out.println("대기 중입니다.");
        }


        // 비교 및 논리 연산 결과를 boolean 변수에 저장
        int score = 85;

        boolean isPass = (score >= 60);
        boolean isPerfect = (score == 100);
        boolean isGoodScore = (score >= 80 && score < 100);

        System.out.println("합격 여부: " + isPass);
        System.out.println("우수 점수 여부: " + isGoodScore);
    }
}