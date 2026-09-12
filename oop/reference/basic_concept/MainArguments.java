package oop.reference.basic_concept;

// main()의 String[] args
// - 프로그램 실행할 때 전달한 값을 배열로 받음
// - args의 각 요소는 String 타입
// - 문자열을 숫자로 사용할 때는 Integer.parseInt()를 사용
public class MainArguments {
    public static void main(String[] args) {

        // 1. 입력값 개수 확인
        if (args.length != 2) {
            System.out.println("두 개의 숫자를 입력해주세요."); // 두 개의 숫자를 입력해주세요.
            return;
        }

        // 2. 문자열을 정수로 변환
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[1]);

        // 3. 두 숫자를 더해서 출력
        int sum = firstNumber + secondNumber;

        System.out.println(
                firstNumber + " + " + secondNumber + " = " + sum
        ); // 예: 10 + 20 = 30
    }
}