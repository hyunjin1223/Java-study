package library.collections.search;

import java.util.NavigableSet;
import java.util.TreeSet;

// TreeSet 기본
// - TreeSet은 이진 탐색 트리를 기반으로 한 Set 컬렉션이다.
// - 객체를 저장할 때 오름차순으로 자동 정렬한다.
// - 정렬된 데이터를 기준으로 다양한 검색 기능을 사용할 수 있다.

public class TreeSetBasic {

    public static void main(String[] args) {

        TreeSet<Integer> temperatures = new TreeSet<>();

        // 온도 저장
        temperatures.add(18);
        temperatures.add(25);
        temperatures.add(30);
        temperatures.add(21);
        temperatures.add(27);

        // 정렬된 데이터 확인
        System.out.println("오름차순: " + temperatures);
        // 오름차순: [18, 21, 25, 27, 30]

        // 가장 작은 값과 가장 큰 값
        System.out.println("최솟값: " + temperatures.first());
        // 최솟값: 18

        System.out.println("최댓값: " + temperatures.last());
        // 최댓값: 30

        // 특정 값보다 바로 낮거나 높은 값
        System.out.println("25보다 낮은 값: " + temperatures.lower(25));
        // 25보다 낮은 값: 21

        System.out.println("25보다 높은 값: " + temperatures.higher(25));
        // 25보다 높은 값: 27

        // 특정 값 이하 또는 이상의 가장 가까운 값
        System.out.println("26 이하의 가장 가까운 값: " + temperatures.floor(26));
        // 26 이하의 가장 가까운 값: 25

        System.out.println("26 이상의 가장 가까운 값: " + temperatures.ceiling(26));
        // 26 이상의 가장 가까운 값: 27

        // 내림차순으로 변경
        NavigableSet<Integer> descending = temperatures.descendingSet();

        System.out.println("내림차순: " + descending);
        // 내림차순: [30, 27, 25, 21, 18]

        // 일정 범위의 값 검색
        NavigableSet<Integer> range =
                temperatures.subSet(20, true, 28, false);

        System.out.println("20 이상 28 미만: " + range);
        // 20 이상 28 미만: [21, 25, 27]

        // 가장 작은 값을 꺼내면서 삭제
        Integer first = temperatures.pollFirst();

        System.out.println("꺼낸 최솟값: " + first);
        // 꺼낸 최솟값: 18

        System.out.println("삭제 후: " + temperatures);
        // 삭제 후: [21, 25, 27, 30]
    }
}