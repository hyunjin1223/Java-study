package library.java_base.math_class;

// Math 클래스
// - 수학 계산에 필요한 정적 메소드를 제공한다.
// - 객체를 생성하지 않고 Math.메소드() 형태로 바로 사용할 수 있다.
// - 절댓값, 올림, 버림, 최댓값, 최솟값, 반올림 등을 사용할 수 있다.

public class MathBasic {

    public static void main(String[] args) {

        // 절댓값
        System.out.println("abs(-8) = " + Math.abs(-8));
        // abs(-8) = 8

        // 올림: 소수점 이하가 있으면 다음 정수로 올린다.
        System.out.println("ceil(4.2) = " + Math.ceil(4.2));
        // ceil(4.2) = 5.0

        // 버림: 소수점 이하를 버린다.
        System.out.println("floor(4.8) = " + Math.floor(4.8));
        // floor(4.8) = 4.0

        // 최댓값 / 최솟값
        System.out.println("max(12, 7) = " + Math.max(12, 7));
        // max(12, 7) = 12

        System.out.println("min(12, 7) = " + Math.min(12, 7));
        // min(12, 7) = 7

        // 반올림
        System.out.println("round(4.4) = " + Math.round(4.4));
        // round(4.4) = 4

        System.out.println("round(4.6) = " + Math.round(4.6));
        // round(4.6) = 5

        // 0.0 이상 1.0 미만의 난수
        double randomValue = Math.random();

        System.out.println("random = " + randomValue);
        // 실행할 때마다 다른 값이 나온다.
    }
}