package library.generic;

// 와일드카드 기본
// - <?>는 어떤 타입이든 받을 수 있는 비한정 와일드카드다.
// - 타입을 지정하지 않은 제네릭 타입을 다룰 때 사용할 수 있다.
// - ?의 실제 타입을 알 수 없기 때문에 null 이외의 객체는 저장(set)할 수 없다.
// - 값을 꺼낼 때는 최상위 타입인 Object로만 다룰 수 있다.

public class WildcardBasic {

    static class Box<T> {

        private T content;

        public Box(T content) {
            this.content = content;
        }

        public T get() {
            return content;
        }

        public void set(T content) {
            this.content = content;
        }
    }

    // 어떤 타입의 Box든 받을 수 있다.
    public static void printBox(Box<?> box) {

        // ?의 실제 타입은 알 수 없으므로 Object로 꺼낸다.
        Object value = box.get();

        System.out.println("내용: " + value);
        System.out.println("타입: " + value.getClass().getSimpleName());

        // 타입 안전성을 위해 null 이외의 객체는 추가할 수 없다.
        // box.set("Data"); // 컴파일 에러
        // box.set(null);  // 가능
    }

    public static void main(String[] args) {

        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> integerBox = new Box<>(100);

        // String 타입의 Box 전달
        printBox(stringBox);

        System.out.println();

        // Integer 타입의 Box 전달
        printBox(integerBox);
    }
}