package library.java_base.object_class;

// equals()
// - Object의 equals()는 두 객체가 같은 객체인지 비교한다.
// - 기본적으로 같은 객체를 참조하는지를 비교한다.
// - equals()를 재정의하면 객체의 내용을 기준으로 비교할 수 있다.
// - 객체의 값이 같은지 확인할 때 주로 재정의해서 사용한다.

class ProductInfo {

    private int number;
    private String name;

    ProductInfo(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // 전달받은 객체가 ProductInfo인지 확인
        if (obj instanceof ProductInfo other) {
            return number == other.number
                    && name.equals(other.name);
        }

        return false;
    }
}

public class Equals {

    public static void main(String[] args) {
        ProductInfo product1 =
                new ProductInfo(100, "Keyboard");

        ProductInfo product2 =
                new ProductInfo(100, "Keyboard");

        ProductInfo product3 =
                new ProductInfo(200, "Mouse");

        // 서로 다른 객체지만 내용이 같음
        System.out.println(product1.equals(product2));
        // true

        // number와 name이 다름
        System.out.println(product1.equals(product3));
        // false
    }
}