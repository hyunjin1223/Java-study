package library.java_base.object_class;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// hashCode()
// - 객체의 값을 바탕으로 해시 코드를 반환한다.
// - equals()가 true인 객체는 같은 hashCode()를 반환해야 한다.
// - HashSet, HashMap 같은 컬렉션에서 객체를 비교할 때 사용된다.
// - equals()를 재정의했다면 hashCode()도 함께 재정의하는 것이 중요하다.

class UserInfo {

    private int id;
    private String name;

    UserInfo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserInfo other) {
            return id == other.id
                    && name.equals(other.name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        // id와 name을 기준으로 해시 코드 생성
        return Objects.hash(id, name);
    }
}

public class HashCode {

    public static void main(String[] args) {
        UserInfo user1 =
                new UserInfo(1, "HyunJin");

        UserInfo user2 =
                new UserInfo(1, "HyunJin");

        // 객체는 서로 다르지만 내용은 같음
        System.out.println(user1.equals(user2));
        // true

        // equals()가 true이므로 hashCode()도 같음
        System.out.println(
                user1.hashCode() == user2.hashCode()
        );
        // true

        Set<UserInfo> users = new HashSet<>();

        users.add(user1);
        users.add(user2);

        // 같은 객체로 판단되어 하나만 저장됨
        System.out.println(users.size());
        // 1
    }
}