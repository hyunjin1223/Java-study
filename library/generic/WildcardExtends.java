package library.generic;

// 상한 와일드카드
// - <? extends T>는 T 타입과 그 자식 타입을 받을 수 있다.
// - 주로 제네릭 객체에서 값을 읽을 때(Producer / Read-Only) 사용한다.
// - 실제 타입은 알 수 없지만 T 타입으로는 안전하게 읽어올 수 있다.
// - 어떤 자식 타입이 들어있을지 알 수 없으므로 null 이외의 객체는 추가할 수 없다.

public class WildcardExtends {

    static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Student extends Person {

        public Student(String name) {
            super(name);
        }
    }

    static class HighStudent extends Student {

        public HighStudent(String name) {
            super(name);
        }
    }

    static class Applicant<T> {

        private T value;

        public Applicant(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    // Student와 그 자식 타입의 Applicant를 받을 수 있다.
    public static void printStudent(Applicant<? extends Student> applicant) {

        // Student 타입으로는 안전하게 값을 읽을 수 있다.
        Student student = applicant.getValue();

        System.out.println(
                "신청자: " + student.getName()
        );

        // 실제 타입을 알 수 없으므로 객체를 추가할 수 없다.
        // applicant.setValue(new Student("Test")); // 컴파일 에러
        // applicant.setValue(null);               // 가능
    }

    public static void main(String[] args) {

        Applicant<Student> studentApplicant =
                new Applicant<>(new Student("Student"));

        Applicant<HighStudent> highStudentApplicant =
                new Applicant<>(new HighStudent("HighStudent"));

        // Student 타입 전달
        printStudent(studentApplicant);

        // Student의 자식 타입도 전달 가능
        printStudent(highStudentApplicant);

        // Person은 Student의 부모 타입이므로 사용할 수 없다.
        // Applicant<Person> personApplicant =
        //         new Applicant<>(new Person("Person"));
        // printStudent(personApplicant);
    }
}