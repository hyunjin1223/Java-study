package library.collections.set;

import java.util.HashSet;
import java.util.Set;

// HashSet 기본
// - HashSet은 Set 인터페이스를 구현한다.
// - 저장 순서를 유지하지 않는다.
// - 동일한 객체는 중복해서 저장하지 않는다.
// - 객체의 동일 여부를 판단할 때 hashCode()와 equals()가 사용된다.

public class HashSetBasic {

    public static void main(String[] args) {

        Set<String> languages = new HashSet<>();

        // 객체 추가
        languages.add("Java");
        languages.add("Python");
        languages.add("Java");
        languages.add("JavaScript");

        // 중복된 Java는 하나만 저장된다.
        System.out.println("크기: " + languages.size());

        // 객체가 있는지 확인
        System.out.println("Python 포함: " + languages.contains("Python"));

        // 객체 삭제
        languages.remove("JavaScript");

        // 저장된 모든 객체 확인
        for (String language : languages) {
            System.out.println(language);
        }
    }
}