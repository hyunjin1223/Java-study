package library.lambda;

// 매개변수가 있는 람다식
// - 매개변수의 타입은 생략할 수 있다.
// - 매개변수가 하나라면 괄호도 생략할 수 있다.
// - 타입을 작성한다면 모든 매개변수에 타입을 작성해야 한다.

public class ParameterLambda {

    @FunctionalInterface
    interface MessageFormatter {
        String format(String name, String message);
    }

    static void printMessage(MessageFormatter formatter) {
        String result = formatter.format("HyunJin", "학습을 시작했습니다.");
        System.out.println(result);
    }

    public static void main(String[] args) {

        // 매개변수 타입을 생략
        printMessage((name, message) ->
                name + "님, " + message
        );

        // 매개변수가 하나인 람다식
        NameConverter converter =
                text -> text.trim().toUpperCase();

        System.out.println(converter.convert("  java  "));
        // JAVA
    }

    @FunctionalInterface
    interface NameConverter {
        String convert(String text);
    }
}