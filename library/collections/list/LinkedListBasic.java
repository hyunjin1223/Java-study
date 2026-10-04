package library.collections.list;

import java.util.LinkedList;
import java.util.List;

// LinkedList 기본
// - LinkedList는 List 인터페이스를 구현한다.
// - 각 객체를 연결해서 관리한다.
// - 중간에 객체를 자주 추가하거나 삭제하는 경우 ArrayList보다 유리할 수 있다.

public class LinkedListBasic {

    public static void main(String[] args) {

        List<String> tasks = new LinkedList<>();

        tasks.add("공부");
        tasks.add("운동");
        tasks.add("게임");

        // 특정 위치에 객체 추가
        tasks.add(1, "식사");

        System.out.println("추가 후: " + tasks);

        // 특정 위치의 객체 삭제
        tasks.remove(2);

        System.out.println("삭제 후: " + tasks);

        // 인덱스를 이용한 조회
        System.out.println("1번 인덱스: " + tasks.get(1));

        // 저장된 객체 수 확인
        System.out.println("크기: " + tasks.size());
    }
}