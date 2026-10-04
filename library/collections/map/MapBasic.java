package library.collections.map;

import java.util.HashMap;
import java.util.Map;

// Map 컬렉션 기본
// - Map은 키와 값을 하나의 쌍으로 저장한다.
// - 키는 중복해서 저장할 수 없고, 값은 중복해서 저장할 수 있다.
// - 같은 키로 값을 저장하면 기존 값이 새로운 값으로 바뀐다.
// - Map은 Collection 인터페이스를 상속하지 않는다.

public class MapBasic {

    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        // 키와 값 저장
        scores.put("math", 88);
        scores.put("english", 92);
        scores.put("science", 85);

        // 같은 키에 새로운 값을 저장하면 기존 값이 변경된다.
        scores.put("math", 95);

        // 크기 확인
        System.out.println("엔트리 수: " + scores.size());
        // 엔트리 수: 3

        // 키로 값 가져오기
        System.out.println("math 점수: " + scores.get("math"));
        // math 점수: 95

        // 키가 존재하는지 확인
        System.out.println("english 존재: " + scores.containsKey("english"));

        // 값이 존재하는지 확인
        System.out.println("85점 존재: " + scores.containsValue(85));

        // 특정 키의 엔트리 삭제
        scores.remove("science");

        System.out.println("삭제 후: " + scores);
    }
}