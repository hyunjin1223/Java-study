package oop.reference.basic_concept;

// null과 NullPointerException (NPE)
// - null: 참조 타입 변수가 아직 어떤 객체의 번지도 가리키지 않고 있음을 의미
// - NPE: null 상태인 변수를 통해 객체의 필드나 메서드를 접근하려고 할 때 발생하는 예외
public class NullPointer {
    public static void main(String[] args) {

        // null 초기화
        String text1 = "안녕";
        String text2 = null;

        System.out.println("text1 == null: " + (text1 == null)); // false
        System.out.println("text2 == null: " + (text2 == null)); // true

        // NullPointerException 발생 예시 (배열)
        int[] scores = null;
        // scores[0] = 100; // NullPointerException 발생 (참조하는 배열 객체가 없음)

        // NullPointerException 발생 예시 (문자열)
        String message = null;
        // System.out.println("총 문자 수: " + message.length()); // NullPointerException 발생
    }
}