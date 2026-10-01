package library.java_base.string_class;

import java.util.StringTokenizer;

// StringTokenizer 클래스
// - 구분자를 기준으로 문자열을 여러 토큰으로 나눌 때 사용한다.
// - split()과 비슷하지만 문자열을 순서대로 하나씩 꺼낼 수 있다.
// - hasMoreTokens()로 남은 토큰이 있는지 확인한다.
// - nextToken()으로 다음 토큰을 가져온다.

public class StringTokenizerBasic {

    public static void main(String[] args) {

        String data = "Java/Python/JavaScript";

        // "/"를 구분자로 사용
        StringTokenizer tokenizer = new StringTokenizer(data, "/");

        // 남은 토큰이 있는 동안 하나씩 가져온다.
        while (tokenizer.hasMoreTokens()) {
            String language = tokenizer.nextToken();
            System.out.println(language);
        }
        // Java
        // Python
        // JavaScript

        System.out.println();

        // 분리할 문자열의 개수 확인
        StringTokenizer cityTokenizer = new StringTokenizer("서울-대구-부산", "-");

        System.out.println("토큰 개수: " + cityTokenizer.countTokens());
        // 토큰 개수: 3
    }
}