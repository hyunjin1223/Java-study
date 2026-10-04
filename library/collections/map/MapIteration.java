package library.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Map 순회
// - keySet()은 모든 키를 Set으로 가져온다.
// - values()는 모든 값을 Collection으로 가져온다.
// - entrySet()은 키와 값을 함께 다룰 수 있는 Entry의 Set을 반환한다.

public class MapIteration {

    public static void main(String[] args) {

        Map<String, String> users = new HashMap<>();

        users.put("user01", "HyunJin");
        users.put("user02", "MinSu");
        users.put("user03", "JiWoo");

        // 키만 가져오기
        System.out.println("[keySet]");
        Set<String> keys = users.keySet();

        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println();

        // 값만 가져오기
        System.out.println("[values]");

        for (String value : users.values()) {
            System.out.println(value);
        }

        System.out.println();

        // 키와 값을 함께 가져오기
        System.out.println("[entrySet]");

        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}