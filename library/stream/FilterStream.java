package library.stream;

import java.util.Arrays;
import java.util.List;

// 요소 필터링
// - distinct()는 중복 요소를 제거한다.
// - filter()는 조건에 맞는 요소만 통과시킨다.
// - 두 연산을 연결하여 필요한 요소만 골라낼 수 있다.

public class FilterStream {

    public static void main(String[] args) {

        List<String> products = Arrays.asList(
                "노트북", "마우스", "노트북",
                "키보드", "헤드셋", "마우스"
        );

        System.out.println("[중복 제거]");

        products.stream()
                .distinct()
                .forEach(product ->
                        System.out.println(product)
                );

        System.out.println();

        System.out.println("[이름이 '마'로 시작하는 상품]");

        products.stream()
                .filter(product ->
                        product.startsWith("마")
                )
                .forEach(product ->
                        System.out.println(product)
                );

        System.out.println();

        System.out.println("[중복 제거 후 '마'로 시작하는 상품]");

        products.stream()
                .distinct()
                .filter(product ->
                        product.startsWith("마")
                )
                .forEach(product ->
                        System.out.println(product)
                );
    }
}