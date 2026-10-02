package library.generic;

// 제네릭 타입
// - 클래스 선언 시 여러 개의 타입 파라미터를 사용할 수 있다.
// - 타입 파라미터는 필드, 메소드의 매개변수와 반환 타입에 사용할 수 있다.
// - 객체를 생성할 때 각각의 타입을 지정하면 그 타입에 맞게 사용된다.
// - 타입 파라미터는 보통 대문자 한 글자로 표현하며, 의미에 따라 이름을 정할 수 있다.

public class GenericType {

    static class Product<K, M> {

        private K kind;
        private M model;

        public K getKind() {
            return kind;
        }

        public void setKind(K kind) {
            this.kind = kind;
        }

        public M getModel() {
            return model;
        }

        public void setModel(M model) {
            this.model = model;
        }
    }

    public static void main(String[] args) {

        // K는 String, M은 Integer로 결정
        Product<String, Integer> product1 = new Product<>();

        product1.setKind("Laptop");
        product1.setModel(2026);

        String kind1 = product1.getKind();
        Integer model1 = product1.getModel();

        System.out.println(kind1);
        // Laptop

        System.out.println(model1);
        // 2026

        System.out.println();

        // K는 String, M은 Double로 결정
        Product<String, Double> product2 = new Product<>();

        product2.setKind("Monitor");
        product2.setModel(27.0);

        String kind2 = product2.getKind();
        Double model2 = product2.getModel();

        System.out.println(kind2);
        // Monitor

        System.out.println(model2);
        // 27.0
    }
}