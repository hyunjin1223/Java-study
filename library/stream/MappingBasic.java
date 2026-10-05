package library.stream;

import java.util.Arrays;
import java.util.List;

// 스트림 요소 변환
// - map()은 각 요소를 다른 값으로 변환한다.
// - mapToInt()는 객체 스트림을 IntStream으로 변환한다.
// - asDoubleStream()은 IntStream을 DoubleStream으로 변환한다.
// - boxed()는 기본 타입 스트림을 객체 스트림으로 변환한다.

public class MappingBasic {

    record Product(String name, int price) {
    }

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Keyboard", 45000),
                new Product("Mouse", 28000),
                new Product("Monitor", 180000)
        );

        // Product에서 상품명만 추출
        products.stream()
                .map(Product::name)
                .forEach(name -> System.out.println("상품명: " + name));

        System.out.println();

        // Product에서 가격만 추출하여 IntStream으로 변환
        products.stream()
                .mapToInt(Product::price)
                .forEach(price -> System.out.println("가격: " + price));

        System.out.println();

        // IntStream을 DoubleStream으로 변환
        int[] numbers = {10, 20, 30};

        Arrays.stream(numbers)
                .asDoubleStream()
                .forEach(value -> System.out.println("double: " + value));

        System.out.println();

        // IntStream을 Stream<Integer>로 변환
        Arrays.stream(numbers)
                .boxed()
                .forEach(value -> System.out.println("Integer: " + value));
    }
}