package library.lambda;

// 리턴값이 있는 람다식
// - 추상 메소드가 값을 반환한다면 람다식에서도 값을 반환해야 한다.
// - 실행문이 하나인 경우 return과 중괄호를 생략할 수 있다.
// - 실행문이 여러 개인 경우 return을 사용한다.

public class ReturnLambda {

    @FunctionalInterface
    interface Calculator {
        int calculate(int x, int y);
    }

    static void calculate(Calculator calculator) {
        int result = calculator.calculate(18, 6);
        System.out.println("계산 결과: " + result);
    }

    public static void main(String[] args) {

        // 실행문이 여러 개인 경우
        calculate((x, y) -> {
            int result = x * y;
            return result;
        });
        // 계산 결과: 108

        // 실행문이 하나인 경우
        calculate((x, y) -> x / y);
        // 계산 결과: 3
    }
}