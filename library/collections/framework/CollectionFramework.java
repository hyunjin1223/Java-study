package library.collections.framework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

// 컬렉션 프레임워크 기본
// - 컬렉션 프레임워크는 객체를 효율적으로 저장하고 관리하기 위한 구조와 기능을 제공한다.
// - List와 Set은 Collection 인터페이스를 상속한다.
// - Map은 Collection을 상속하지 않고 키와 값의 쌍으로 데이터를 관리한다.
// - 자주 사용하는 구현 클래스로 ArrayList, HashSet, HashMap 등이 있다.

public class CollectionFramework {

    public static void main(String[] args) {

        // List: 저장 순서를 유지하고 중복을 허용한다.
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Java");

        // Set: 중복을 허용하지 않는다.
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("Java");

        // Map: 키와 값을 하나의 쌍으로 저장한다.
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 90);
        map.put("Python", 85);

        System.out.println("List: " + list);
        System.out.println("Set: " + set);
        System.out.println("Map: " + map);
    }
}