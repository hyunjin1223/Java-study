package library.stream;

import java.util.Arrays;
import java.util.List;

// 스트림 파이프라인
// - 스트림은 여러 연산을 연결하여 하나의 처리 과정으로 만들 수 있다.
// - 중간 연산은 새로운 스트림을 반환하며 여러 번 연결할 수 있다.
// - 최종 연산이 실행될 때 실제 요소 처리가 시작된다.

public class StreamPipeline {

    static class Product {
        private final String name;
        private final int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + price + "원)";
        }
    }

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("키보드", 70000),
                new Product("마우스", 40000),
                new Product("헤드셋", 90000),
                new Product("웹캠", 50000)
        );

        // 중간 처리: 상품 객체를 가격으로 변환
        // 최종 처리: 평균 계산
        double averagePrice = products.stream()
                .mapToInt(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("평균 가격: " + averagePrice);
        // 평균 가격: 62500.0
    }
}