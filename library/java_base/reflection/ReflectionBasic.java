package library.java_base.reflection;

// 리플렉션 기본
// - 실행 중인 프로그램에서 클래스의 정보를 확인할 수 있다.
// - Class 객체를 이용하여 클래스의 이름과 패키지 등의 정보를 가져올 수 있다.
// - Class 객체를 얻는 방법은 3가지가 있다.
//   1) 클래스.class : 컴파일 시점에 클래스 타입을 알고 있을 때 사용
//   2) Class.forName("풀경로") : 클래스 이름을 문자열로 받아 동적으로 로딩할 때 사용
//   3) 객체.getClass() : 이미 생성된 객체가 있을 때 사용

public class ReflectionBasic {

    static class User {

        private String name;

        User(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {

        // 1. 클래스의 .class를 이용해서 Class 객체 가져오기
        Class<?> class1 = User.class;

        // 2. 클래스의 전체 이름을 이용해서 Class 객체 가져오기
        Class<?> class2 = Class.forName(
                "library.java_base.reflection.ReflectionBasic$User"
        );

        // 3. 객체를 이용해서 Class 객체 가져오기
        User user = new User("HyunJin");
        Class<?> class3 = user.getClass();

        // 같은 클래스를 나타내므로 같은 Class 객체를 참조한다.
        System.out.println(class1 == class2);
        // true

        System.out.println(class2 == class3);
        // true

        System.out.println();

        // 클래스 기본 정보
        System.out.println("패키지: " + class1.getPackageName());
        System.out.println("클래스: " + class1.getSimpleName());
        System.out.println("전체 이름: " + class1.getName());
    }
}