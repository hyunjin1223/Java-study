package library.java_base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

// 리플렉션으로 클래스 멤버 확인
// - Class 객체를 이용하면 클래스에 선언된 생성자, 필드, 메소드 정보를 가져올 수 있다.
// - getDeclaredXxx()는 접근 제어자와 상관없이 해당 클래스에 선언된 멤버를 가져온다.
// - getDeclaredXxx()는 부모 클래스로부터 상속받은 멤버는 포함하지 않는다.
// - getXxx()는 public 멤버를 가져오며, 상속받은 public 멤버까지 포함할 수 있다.

public class ReflectionMember {

    static class User {

        private String name;
        private int age;

        User() {
        }

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        void introduce(String greeting) {
            System.out.println(greeting + ", " + name);
        }
    }

    public static void main(String[] args) {

        Class<?> clazz = User.class;

        // 선언된 생성자 확인
        // - getDeclaredConstructors()로 현재 클래스의 생성자 정보를 가져온다.
        System.out.println("[생성자]");

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {

            System.out.print(constructor.getName() + "(");

            // 생성자의 매개변수 정보 확인
            Parameter[] parameters = constructor.getParameters();

            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getType().getSimpleName());

                if (i < parameters.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(")");
        }

        System.out.println();

        // 선언된 필드 확인
        // - getDeclaredFields()로 현재 클래스의 필드 정보를 가져온다.
        System.out.println("[필드]");

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }

        System.out.println();

        // 선언된 메소드 확인
        // - getDeclaredMethods()로 현재 클래스의 메소드 정보를 가져온다.
        System.out.println("[메소드]");

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.print(method.getReturnType().getSimpleName() + " " + method.getName() + "(");

            // 메소드의 매개변수 정보 확인
            Parameter[] parameters = method.getParameters();

            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getType().getSimpleName());

                if (i < parameters.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(")");
        }
    }
}