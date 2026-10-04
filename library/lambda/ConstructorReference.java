package library.lambda;

import java.util.function.BiFunction;
import java.util.function.Supplier;

// 생성자 참조
// - 생성자 참조는 클래스 이름::new 형태로 작성한다.
// - 람다식으로 객체를 생성하는 코드를 간단하게 표현할 수 있다.
// - 생성자의 매개변수와 함수형 인터페이스의 매개변수가 일치해야 한다.

public class ConstructorReference {

    static class User {
        private String id;
        private int age;

        public User() {
            this.id = "guest";
            this.age = 0;
        }

        public User(String id, int age) {
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{id='" + id + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {

        // 매개변수가 없는 생성자 참조
        Supplier<User> createUser = User::new;

        User guest = createUser.get();

        System.out.println(guest);
        // User{id='guest', age=0}

        // 매개변수가 있는 생성자 참조
        BiFunction<String, Integer, User> createUserWithInfo = User::new;

        User user = createUserWithInfo.apply("user01", 20);

        System.out.println(user);
        // User{id='user01', age=20}
    }
}