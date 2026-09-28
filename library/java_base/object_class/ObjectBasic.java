package library.java_base.object_class;

// Object 클래스
// - 모든 클래스는 별도로 extends하지 않아도 Object 클래스를 상속한다.
// - Object에는 모든 클래스에서 사용할 수 있는 기본 메소드가 제공된다.
// - 대표적으로 equals(), hashCode(), toString() 등이 있다.
// - 자식 클래스에서 필요하면 이 메소드들을 재정의할 수 있다.

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

public class ObjectBasic {

    public static void main(String[] args) {
        Product product = new Product("Keyboard");

        // Object에서 물려받은 메소드 사용
        System.out.println(product.toString());
        // Product@...

        System.out.println(product.hashCode());
        // 객체마다 다른 해시 코드

        // 같은 객체를 비교하므로 true
        System.out.println(product.equals(product));
        // true
    }
}