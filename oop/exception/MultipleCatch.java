package oop.exception;

// 여러 예외 처리
// - 예외 종류에 따라 서로 다른 처리를 할 수 있다.
// - 하위 예외 클래스는 상위 예외 클래스보다 먼저 catch해야 한다.
// - 여러 예외를 같은 방식으로 처리할 때는 | 로 묶을 수 있다.

public class MultipleCatch {

    public static void main(String[] args) {
        String[] portInputs = {"8080", "web", "70000"};

        for (String input : portInputs) {
            try {
                int port = Integer.parseInt(input);

                if (port < 1 || port > 65535) {
                    throw new IllegalArgumentException("포트 범위를 벗어났습니다.");
                }

                System.out.println("사용할 포트: " + port);

            } catch (NumberFormatException e) {
                // IllegalArgumentException의 하위 클래스이므로 먼저 처리
                System.out.println("숫자가 아닌 포트: " + input);

            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 설정: " + e.getMessage());
            }
        }

        System.out.println();

        // 같은 방식으로 처리할 예외는 하나의 catch로 묶을 수 있다.
        int[] numbers = {10, 20, 30};

        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("배열을 올바르게 참조하지 못했습니다.");
        }
    }
}