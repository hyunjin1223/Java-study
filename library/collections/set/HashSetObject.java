package library.collections.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// HashSet과 객체의 동등성
// - HashSet은 hashCode()와 equals()를 이용하여 객체의 중복 여부를 판단한다.
// - 서로 다른 객체라도 두 메소드의 결과가 같으면 같은 객체로 판단할 수 있다.

public class HashSetObject {

    static class Member {
        private String id;
        private int level;

        public Member(String id, int level) {
            this.id = id;
            this.level = level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, level);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Member other)) {
                return false;
            }

            return level == other.level
                    && Objects.equals(id, other.id);
        }
    }

    public static void main(String[] args) {

        Set<Member> members = new HashSet<>();

        members.add(new Member("user01", 3));
        members.add(new Member("user01", 3));
        members.add(new Member("user02", 3));

        // user01 / 3 객체는 내용이 같기 때문에 하나만 저장된다.
        System.out.println("저장된 회원 수: " + members.size());
        // 저장된 회원 수: 2
    }
}