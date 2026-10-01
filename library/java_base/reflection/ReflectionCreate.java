package library.java_base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 리플렉션으로 객체 생성, 메소드 호출 및 private 필드 접근
// - Class 객체에서 생성자를 가져와 newInstance()로 객체를 동적 생성할 수 있다.
// - Method 객체의 invoke()를 이용하면 객체의 메소드를 실행할 수 있다.
// - setAccessible(true)를 사용하면 private 멤버에도 접근할 수 있다.

public class ReflectionCreate {

    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void introduce() {
            System.out.println("이름: " + name + ", 나이: " + age);
        }
    }

    public static void main(String[] args) throws Exception {

        Class<?> clazz = User.class;

        // 1. String과 int를 매개변수로 사용하는 생성자 가져오기
        Constructor<?> constructor =
                clazz.getDeclaredConstructor(String.class, int.class);

        // 생성자를 이용해 객체 생성
        User user = (User) constructor.newInstance("HyunJin", 20);

        user.introduce();
        // 이름: HyunJin, 나이: 20

        // 2. Method 객체를 이용해서 메소드 호출
        Method method = clazz.getDeclaredMethod("introduce");

        method.invoke(user);
        // 이름: HyunJin, 나이: 20

        System.out.println();

        // 3. private 필드 접근 및 값 변경
        Field field = clazz.getDeclaredField("name");

        field.setAccessible(true);

        System.out.println("기존 name: " + field.get(user));
        // 기존 name: HyunJin

        field.set(user, "NewHyunJin");

        user.introduce();
        // 이름: NewHyunJin, 나이: 20
    }
}