package library.collections.unmodifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 수정할 수 없는 컬렉션
// - List.of(), Set.of(), Map.of()로 수정할 수 없는 컬렉션을 직접 생성할 수 있다.
// - List.copyOf(), Set.copyOf(), Map.copyOf()로 기존 컬렉션을 수정할 수 없는 형태로 만들 수 있다.
// - 수정하려고 하면 UnsupportedOperationException이 발생한다.

public class UnmodifiableBasic {

    public static void main(String[] args) {

        // of()로 수정할 수 없는 컬렉션 생성
        List<String> languages =
                List.of("Java", "Python", "JavaScript");

        Set<String> tools =
                Set.of("Git", "Docker", "IntelliJ");

        Map<String, Integer> scores =
                Map.of(
                        "Java", 90,
                        "Python", 85,
                        "JavaScript", 88
                );

        System.out.println("List: " + languages);
        System.out.println("Set: " + tools);
        System.out.println("Map: " + scores);

        // 기존 컬렉션 생성
        List<String> mutableList =
                new ArrayList<>(List.of("A", "B", "C"));

        Set<String> mutableSet =
                new HashSet<>(Set.of("X", "Y", "Z"));

        Map<String, Integer> mutableMap =
                new HashMap<>(Map.of(
                        "A", 1,
                        "B", 2,
                        "C", 3
                ));

        // copyOf()로 수정할 수 없는 컬렉션 생성
        List<String> copiedList = List.copyOf(mutableList);
        Set<String> copiedSet = Set.copyOf(mutableSet);
        Map<String, Integer> copiedMap = Map.copyOf(mutableMap);

        System.out.println("복사한 List: " + copiedList);
        System.out.println("복사한 Set: " + copiedSet);
        System.out.println("복사한 Map: " + copiedMap);

        // 수정하려고 하면 예외가 발생한다.
        try {
            copiedList.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("List는 수정할 수 없습니다.");
        }

        try {
            copiedSet.remove("X");
        } catch (UnsupportedOperationException e) {
            System.out.println("Set은 수정할 수 없습니다.");
        }

        try {
            copiedMap.put("D", 4);
        } catch (UnsupportedOperationException e) {
            System.out.println("Map은 수정할 수 없습니다.");
        }
    }
}