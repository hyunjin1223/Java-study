package library.generic;

// 제네릭 메소드
// - 메소드 선언부에서 타입 파라미터를 정의한다.
// - 호출할 때 전달한 값의 타입에 따라 T가 결정된다.
// - 반환 타입과 매개변수에 같은 타입 파라미터를 사용할 수 있다.

public class GenericMethod {

    static class Box<T> {

        private T content;

        public void set(T content) {
            this.content = content;
        }

        public T get() {
            return content;
        }
    }

    // 전달받은 값을 Box<T>에 담아서 반환
    public static <T> Box<T> boxing(T value) {

        Box<T> box = new Box<>();
        box.set(value);

        return box;
    }

    public static void main(String[] args) {

        // T가 Integer로 결정 (타입 추론)
        Box<Integer> integerBox = boxing(100);

        int intValue = integerBox.get();
        System.out.println(intValue);
        // 100

        // T가 String으로 결정 (타입 추론)
        Box<String> stringBox = boxing("홍길동");

        String stringValue = stringBox.get();
        System.out.println(stringValue);
        // 홍길동

        System.out.println();

        // 타입 파라미터를 직접 지정해서 호출
        Box<String> stringBox2 = GenericMethod.<String>boxing("이순신");

        String stringValue2 = stringBox2.get();
        System.out.println(stringValue2);
        // 이순신
    }
}