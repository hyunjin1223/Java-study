package library.lambda;

// 메소드 참조
// - 메소드 참조는 이미 존재하는 메소드를 람다식 대신 사용할 수 있게 한다.
// - 클래스 이름::메소드 이름 형태로 정적 메소드를 참조할 수 있다.
// - 객체 이름::메소드 이름 형태로 인스턴스 메소드를 참조할 수 있다.
// - 람다식과 메소드의 매개변수와 반환 타입이 맞아야 한다.

public class MethodReference {

    @FunctionalInterface
    interface NumberOperation {
        int apply(int x, int y);
    }

    @FunctionalInterface
    interface TextOperation {
        String apply(String text);
    }

    static class Calculator {

        public static int add(int x, int y) {
            return x + y;
        }

        public int multiply(int x, int y) {
            return x * y;
        }
    }

    static class TextFormatter {

        public String format(String text) {
            return text.trim().toUpperCase();
        }
    }

    public static void main(String[] args) {

        // 정적 메소드 참조
        NumberOperation add = Calculator::add;

        System.out.println("덧셈: " + add.apply(10, 20));
        // 덧셈: 30

        // 인스턴스 메소드 참조
        Calculator calculator = new Calculator();
        NumberOperation multiply = calculator::multiply;

        System.out.println("곱셈: " + multiply.apply(4, 5));
        // 곱셈: 20

        // 문자열 처리 메소드 참조
        TextFormatter formatter = new TextFormatter();
        TextOperation textOperation = formatter::format;

        System.out.println(textOperation.apply("  hello java  "));
        // HELLO JAVA
    }
}