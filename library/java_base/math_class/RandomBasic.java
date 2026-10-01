package library.java_base.math_class;

import java.util.Random;

// Random 클래스
// - 다양한 형태의 난수를 생성할 수 있다.
// - seed 값을 지정하면 같은 seed에서 같은 난수 순서가 나온다.
// - nextInt()를 이용하면 원하는 범위의 정수를 만들 수 있다.

public class RandomBasic {

    public static void main(String[] args) {

        // seed를 지정하면 실행할 때마다 같은 난수를 얻을 수 있다.
        Random random = new Random(123);

        // 0 이상 100 미만의 정수
        int number = random.nextInt(100);

        System.out.println("0 ~ 99: " + number);

        // 1 ~ 10 범위의 정수
        int dice = random.nextInt(10) + 1;

        System.out.println("1 ~ 10: " + dice);

        // 여러 개의 난수 생성
        System.out.print("난수 5개: ");

        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextInt(50) + 1 + " ");
        }

        System.out.println();
    }
}