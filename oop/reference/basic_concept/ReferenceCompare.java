package oop.reference.basic_concept;

// 참조 타입의 ==, != 연산
// - 기본 타입(primitive): 변수에 실제 '값' 자체가 저장됨
// - 참조 타입(reference): 힙 영역에 생성된 객체의 '주소(번지)'가 저장됨
// - 참조 타입에서 == 연산자는 '값이 같은지'가 아니라 '동일한 객체(주소)를 참조하는지' 비교함
public class ReferenceCompare {
    public static void main(String[] args) {

        // 기본 타입 비교 (값 자체를 비교)
        int score = 95;
        double height = 175.5;

        // 참조 타입 비교 (배열)
        int[] list1 = new int[] { 10, 20, 30 }; // 힙 영역 10번지에 생성
        int[] list2 = new int[] { 10, 20, 30 }; // 힙 영역 20번지에 생성
        int[] list3 = list2;                    // list2의 번지(20번지)를 그대로 복사

        // list1과 list2는 내부 값은 같아도 서로 다른 객체를 참조함 (false)
        System.out.println("list1 == list2: " + (list1 == list2)); // false
        System.out.println("list1 != list2: " + (list1 != list2)); // true

        // list2와 list3은 동일한 객체의 번지를 참조함 (true)
        System.out.println("list2 == list3: " + (list2 == list3)); // true
        System.out.println("list2 != list3: " + (list2 != list3)); // false
    }
}