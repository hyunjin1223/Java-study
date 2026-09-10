package oop.reference.basic_concept;

// 쓰레기 객체(Garbage)와 가비지 컬렉터(Garbage Collector)
// - 어떤 변수에서도 더 이상 참조하지 않는 힙 영역의 객체 = 쓰레기 객체
// - 자바는 가비지 컬렉터가 주기적으로 쓰레기 객체를 자동으로 메모리에서 해제함
public class GarbageObject {
    public static void main(String[] args) {

        // 1. null을 통한 참조 끊기
        String category = "음악"; // "음악" String 객체 참조
        category = null;        // "음악" 객체의 번지를 잃어버림 -> 쓰레기 객체 형성

        // 2. 다른 객체 재할당을 통한 참조 끊기
        String title = "자바 기초";
        title = "객체 지향";     // "자바 기초" 객체 참조가 끊어지고 "객체 지향" 참조 -> "자바 기초" 객체는 쓰레기 객체 형성

        // 3. 다른 변수가 여전히 참조 중인 경우
        String item1 = "노트북";
        String item2 = item1;   // item2도 "노트북" 객체를 함께 참조
        item1 = null;           // item1이 참조를 끊어도 item2가 여전히 참조 중이므로 쓰레기 객체가 아님

        System.out.println("item2: " + item2); // 노트북 출력
    }
}