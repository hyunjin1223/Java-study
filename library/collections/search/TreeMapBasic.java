package library.collections.search;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

// TreeMap 기본
// - TreeMap은 이진 탐색 트리를 기반으로 한 Map 컬렉션이다.
// - 키를 기준으로 엔트리를 자동 정렬한다.
// - 정렬된 키를 기준으로 다양한 검색 기능을 사용할 수 있다.

public class TreeMapBasic {

    public static void main(String[] args) {

        TreeMap<Integer, String> users = new TreeMap<>();

        // 사용자 ID와 이름 저장
        users.put(101, "HyunJin");
        users.put(105, "MinSu");
        users.put(108, "JiWoo");
        users.put(112, "SeoJun");
        users.put(120, "Yuna");

        // 키를 기준으로 정렬된 엔트리 출력
        System.out.println("전체 사용자: " + users);
        // 전체 사용자: {101=HyunJin, 105=MinSu, 108=JiWoo, 112=SeoJun, 120=Yuna}

        // 가장 작은 키와 가장 큰 키의 Entry 가져오기
        Map.Entry<Integer, String> first = users.firstEntry();
        Map.Entry<Integer, String> last = users.lastEntry();

        System.out.println(
                "첫 번째 사용자: " + first.getKey() + " - " + first.getValue()
        );

        System.out.println(
                "마지막 사용자: " + last.getKey() + " - " + last.getValue()
        );

        // 특정 키보다 바로 낮거나 높은 Entry 검색
        Map.Entry<Integer, String> lower = users.lowerEntry(110);
        Map.Entry<Integer, String> higher = users.higherEntry(110);

        System.out.println("110보다 낮은 사용자: " + lower);
        System.out.println("110보다 높은 사용자: " + higher);

        // 특정 키 이하 또는 이상의 가장 가까운 Entry 검색
        System.out.println("110 이하: " + users.floorEntry(110));
        System.out.println("110 이상: " + users.ceilingEntry(110));

        // 내림차순 Map
        NavigableMap<Integer, String> descending = users.descendingMap();

        System.out.println("내림차순: " + descending);
        // 내림차순: {120=Yuna, 112=SeoJun, 108=JiWoo, 105=MinSu, 101=HyunJin}

        // 특정 키 범위 검색
        NavigableMap<Integer, String> range =
                users.subMap(105, true, 120, false);

        System.out.println("105 이상 120 미만: " + range);
        // 105 이상 120 미만: {105=MinSu, 108=JiWoo, 112=SeoJun}

        // 가장 작은 Entry를 꺼내면서 삭제
        Map.Entry<Integer, String> removed = users.pollFirstEntry();

        System.out.println("삭제된 사용자: " + removed);
        System.out.println("삭제 후: " + users);
    }
}