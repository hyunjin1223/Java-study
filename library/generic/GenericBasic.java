package library.generic;

// 제네릭 기본
// - 타입을 미리 정하지 않고 사용할 때 원하는 타입으로 지정할 수 있다.
// - 클래스 선언 시 타입 파라미터를 사용하고, 객체 생성 시 실제 타입을 결정한다.
// - Object 타입과 달리 꺼낼 때 형변환이 필요하지 않다.
// - 컴파일 시점에 타입을 검사하여 잘못된 타입 사용을 줄이고 형변환 오류를 예방한다.

public class GenericBasic {

    // Object를 사용하면 여러 타입을 저장할 수 있지만
    // 값을 꺼낼 때 직접 형변환해야 한다.
    static class ObjectBox {

        private Object content;

        public void set(Object content) {
            this.content = content;
        }

        public Object get() {
            return content;
        }
    }

    // T를 사용하면 객체를 생성할 때 저장할 타입을 결정할 수 있다.
    static class Box<T> {

        private T content;

        public void set(T content) {
            this.content = content;
        }

        public T get() {
            return content;
        }
    }

    public static void main(String[] args) {

        // Object 사용
        ObjectBox objectBox = new ObjectBox();
        objectBox.set("Hello");

        String objectValue = (String) objectBox.get();
        System.out.println(objectValue);
        // Hello

        System.out.println();

        // String 타입으로 결정된 제네릭 Box
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");

        String stringValue = stringBox.get();
        System.out.println(stringValue);
        // Hello

        // Integer 타입으로 결정된 제네릭 Box
        Box<Integer> integerBox = new Box<>();
        integerBox.set(100);

        int intValue = integerBox.get();
        System.out.println(intValue);
        // 100
    }
}