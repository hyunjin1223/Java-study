package library.collections.list;

import java.util.List;
import java.util.Vector;

// Vector 기본
// - Vector는 List 인터페이스를 구현하는 클래스다.
// - ArrayList와 비슷하게 인덱스로 객체를 관리한다.
// - Vector의 주요 메소드는 동기화되어 있어 여러 스레드에서 사용할 수 있다.

public class VectorBasic {

    public static void main(String[] args) {

        List<Integer> numbers = new Vector<>();

        // 객체 추가
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // 특정 위치에 객체 추가
        numbers.add(1, 15);

        // 객체 조회
        System.out.println("0번 인덱스: " + numbers.get(0));

        // 객체 수정
        numbers.set(2, 25);

        // 객체 삭제
        numbers.remove(Integer.valueOf(10));

        // 저장된 객체 확인
        System.out.println("Vector: " + numbers);
        System.out.println("크기: " + numbers.size());
    }
}