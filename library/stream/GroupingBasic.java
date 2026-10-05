package library.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 스트림 요소 그룹화
// - groupingBy()는 같은 조건의 요소를 하나의 그룹으로 묶는다.
// - 분류 기준은 Function으로 지정한다.
// - 두 번째 Collector를 사용하면 그룹별 집계도 할 수 있다.

public class GroupingBasic {

    record Product(String name, String category, int price) {
    }

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Keyboard", "PC", 45000),
                new Product("Mouse", "PC", 28000),
                new Product("Monitor", "PC", 180000),
                new Product("Desk", "Furniture", 120000),
                new Product("Chair", "Furniture", 85000)
        );

        // 카테고리별로 상품을 그룹화
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::category));

        System.out.println("[카테고리별 상품]");
        grouped.forEach((category, productList) -> {
            System.out.println(category);

            productList.forEach(product ->
                    System.out.println(" - " + product.name()));
        });

        System.out.println();

        // 카테고리별 평균 가격 계산
        Map<String, Double> averagePrice = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.averagingInt(Product::price)
                ));

        System.out.println("[카테고리별 평균 가격]");
        averagePrice.forEach((category, average) ->
                System.out.println(category + ": " + average));
    }
}