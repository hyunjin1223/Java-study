package library.java_base.object_class;

// record
// - 여러 데이터를 저장하는 객체를 간단하게 선언할 수 있다.
// - 선언한 컴포넌트를 기준으로 생성자와 접근 메소드가 자동으로 만들어진다.
// - equals(), hashCode(), toString()도 자동으로 제공된다.
// - 데이터를 단순하게 저장하는 객체를 만들 때 사용할 수 있다.

record UserRecord(String id, String name, int age) {
}

public class RecordBasic {

    public static void main(String[] args) {
        UserRecord user1 =
                new UserRecord("user01", "HyunJin", 20);

        // record의 접근 메소드 사용
        System.out.println(user1.id());
        // user01

        System.out.println(user1.name());
        // HyunJin

        System.out.println(user1.age());
        // 20

        // toString()이 자동으로 제공됨
        System.out.println(user1);
        // UserRecord[id=user01, name=HyunJin, age=20]

        UserRecord user2 =
                new UserRecord("user01", "HyunJin", 20);

        // 같은 값을 가지고 있으므로 true
        // equals()도 자동으로 만들어짐
        System.out.println(user1.equals(user2));
        // true
    }
}