package library.collections.map;

import java.util.Hashtable;
import java.util.Map;

// Hashtable 기본
// - Hashtable은 Map 인터페이스를 구현한다.
// - 주요 메소드가 동기화되어 여러 스레드에서 사용할 수 있다.
// - HashMap과 달리 null 키와 null 값을 저장할 수 없다.
// - 기존 코드에서는 사용할 수 있지만, 새로운 코드에서는 다른 Map 구현을 주로 사용한다.

public class HashtableBasic {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new Hashtable<>();

        // 키와 값 저장
        inventory.put("keyboard", 12);
        inventory.put("mouse", 20);
        inventory.put("monitor", 5);

        // 값 조회
        System.out.println("keyboard 수량: " + inventory.get("keyboard"));
        // keyboard 수량: 12

        // 값 변경
        inventory.put("mouse", 18);

        // 키 존재 여부 확인
        System.out.println("monitor 존재: " + inventory.containsKey("monitor"));

        // 객체 삭제
        inventory.remove("monitor");

        System.out.println("현재 재고: " + inventory);

        // Hashtable은 null을 허용하지 않는다.
        // inventory.put(null, 10);    // NullPointerException
        // inventory.put("desk", null); // NullPointerException
    }
}