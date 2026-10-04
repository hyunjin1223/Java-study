package library.collections.list;

import java.util.ArrayList;
import java.util.List;

// ArrayList 기본
// - ArrayList는 List 인터페이스를 구현한다.
// - 저장 순서를 유지하고 중복 객체를 저장할 수 있다.
// - 인덱스를 이용하여 객체를 추가, 조회, 수정, 삭제할 수 있다.

public class ArrayListBasic {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        // 객체 추가
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");

        // 특정 인덱스에 객체 추가
        fruits.add(1, "Grape");

        // 저장된 객체 수 확인
        System.out.println("크기: " + fruits.size());

        // 특정 인덱스의 객체 가져오기
        System.out.println("2번 인덱스: " + fruits.get(2));

        // 특정 객체가 있는지 확인
        System.out.println("Banana 포함: " + fruits.contains("Banana"));

        // 특정 인덱스의 객체 수정
        fruits.set(0, "Mango");

        // 인덱스로 객체 삭제
        fruits.remove(1);

        // 객체로 삭제
        fruits.remove("Apple");

        // 전체 객체 확인
        System.out.println("전체 데이터: " + fruits);

        // 향상된 for문으로 객체를 하나씩 가져온다.
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}