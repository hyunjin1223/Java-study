package library.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// 스트림 요소 수집
// - collect()는 스트림 요소를 원하는 형태의 컬렉션으로 모을 수 있다.
// - toList()는 List로 수집한다.
// - toSet()은 Set으로 수집한다.
// - toMap()은 키와 값의 형태로 수집하며, 중복 키가 발생하면 병합 함수를 사용할 수 있다.

public class CollectingBasic {

    record Product(String name, String category, int price) {
    }

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Keyboard", "PC", 45000),
                new Product("Mouse", "PC", 28000),
                new Product("Desk", "Furniture", 120000),
                new Product("Chair", "Furniture", 85000)
        );

        // 가격이 50000원 이상인 상품만 List로 수집
        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.price() >= 50000)
                .collect(Collectors.toList());

        System.out.println("[고가 상품]");
        expensiveProducts.forEach(product ->
                System.out.println(product.name() + ": " + product.price()));

        System.out.println();

        // 카테고리를 Set으로 수집
        Set<String> categories = products.stream()
                .map(Product::category)
                .collect(Collectors.toSet());

        System.out.println("[카테고리]");
        System.out.println(categories);

        System.out.println();

        // 상품명을 키, 가격을 값으로 하는 Map 생성
        Map<String, Integer> priceMap = products.stream()
                .collect(Collectors.toMap(
                        Product::name,
                        Product::price,
                        (existing, replacement) -> existing
                ));

        System.out.println("[가격 Map]");
        System.out.println(priceMap);
    }
}