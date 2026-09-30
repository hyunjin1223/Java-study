package library.java_base.object_class;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// Lombok
// - 반복해서 작성하는 코드를 어노테이션으로 줄여준다.
// - Getter, equals(), hashCode(), toString() 등을 자동으로 생성할 수 있다.
// - 직접 메소드를 작성하지 않아도 필요한 기능을 사용할 수 있다.
// - Lombok을 사용하려면 프로젝트에 라이브러리가 추가되어 있어야 한다.

@Getter
@ToString
@EqualsAndHashCode
class MemberInfo {

    private int id;
    private String name;

    MemberInfo(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Lombok {

    public static void main(String[] args) {
        MemberInfo member1 =
                new MemberInfo(1, "HyunJin");

        MemberInfo member2 =
                new MemberInfo(1, "HyunJin");

        // @Getter가 getter 메소드를 자동 생성
        System.out.println(member1.getId());
        // 1

        System.out.println(member1.getName());
        // HyunJin

        // @ToString이 toString()을 자동 생성
        System.out.println(member1);
        // MemberInfo(id=1, name=HyunJin)

        // @EqualsAndHashCode가 equals()와 hashCode()를 자동 생성
        System.out.println(member1.equals(member2));
        // true

        System.out.println(
                member1.hashCode() == member2.hashCode()
        );
        // true
    }
}