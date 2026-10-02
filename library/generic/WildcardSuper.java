package library.generic;

// 하한 와일드카드
// - <? super T>는 T 타입과 그 부모 타입을 받을 수 있다.
// - 주로 제네릭 객체에 값을 넣을 때(Consumer / Write) 사용한다.
// - T 타입과 그 자식 객체를 안전하게 저장할 수 있다.
// - 값을 꺼낼 때는 구체적인 타입을 알 수 없으므로 Object 타입으로만 다룰 수 있다.

public class WildcardSuper {

    static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Worker extends Person {

        public Worker(String name) {
            super(name);
        }
    }

    static class Student extends Person {

        public Student(String name) {
            super(name);
        }
    }

    static class Container<T> {

        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }

    // Worker와 Worker의 부모 타입을 받을 수 있다.
    public static void setWorker(
            Container<? super Worker> container,
            Worker worker
    ) {
        // Worker 객체는 안전하게 저장할 수 있다.
        container.set(worker);

        // 어떤 부모 타입의 Container인지 알 수 없으므로 Object로 꺼낸다.
        Object objectValue = container.get();

        System.out.println(
                "저장된 객체 타입: " + objectValue.getClass().getSimpleName()
        );
    }

    public static void main(String[] args) {

        Container<Worker> workerContainer = new Container<>();

        Container<Person> personContainer = new Container<>();

        // Worker 타입 Container
        setWorker(workerContainer, new Worker("Worker"));

        System.out.println();

        // Worker의 부모 타입인 Person Container
        setWorker(personContainer, new Worker("Person Container"));

        // Student는 Worker의 부모 타입이 아니므로 사용할 수 없다.
        // Container<Student> studentContainer =
        //         new Container<>();
        // setWorker(studentContainer, new Worker("Worker"));
    }
}