package oop.classes.encapsulation;

// 캡슐화와 Getter / Setter
// - 중요한 필드를 private으로 선언하면 외부에서 직접 값을 변경하지 못하게 할 수 있다.
// - Getter는 private 필드의 값을 읽을 때 사용한다.
// - Setter는 private 필드의 값을 변경할 때 사용한다.
// - Setter에서 조건을 검사하면 잘못된 값이 저장되는 것을 막을 수 있다.
class User {
    private String name;
    private int age;

    // Getter: 이름 가져오기
    public String getName() {
        return name;
    }

    // Getter: 나이 가져오기
    public int getAge() {
        return age;
    }

    // Setter: 이름 변경
    public void setName(String name) {
        this.name = name;
    }

    // Setter: 나이 변경
    public void setAge(int age) {
        if (age < 0) {
            return; // 음수는 저장하지 않음
        }

        this.age = age;
    }
}

public class GetterSetter {
    public static void main(String[] args) {
        User user = new User();

        // private 필드이므로 직접 접근할 수 없다.
        // user.name = "HyunJin"; // 컴파일 에러
        // user.age = 20;         // 컴파일 에러

        // Setter를 사용해 값 변경
        user.setName("HyunJin");
        user.setAge(20);

        // Getter를 사용해 값 확인
        System.out.println("이름: " + user.getName());
        // 이름: HyunJin

        System.out.println("나이: " + user.getAge());
        // 나이: 20

        // 잘못된 값은 Setter에서 막힘
        user.setAge(-1);

        System.out.println("나이: " + user.getAge());
        // 나이: 20
    }
}