package oop.reference.string;

// String 생성 방식에 따른 객체 참조 차이와 문자열 비교
// - 리터럴 생성: 동일한 문자열 리터럴은 String Constant Pool의 객체를 공유
// - new 객체 생성: 내용이 같아도 새로운 String 객체가 생성됨
// - == 연산자는 객체의 참조값을 비교하고, equals()는 문자열의 내용을 비교
public class StringEquals {
    public static void main(String[] args) {

        // 1. 리터럴로 생성
        String langA = "자바";
        String langB = "자바";

        System.out.println("리터럴 참조 비교: " + (langA == langB));    // true
        System.out.println("리터럴 내용 비교: " + langA.equals(langB)); // true


        // 2. new 연산자로 생성
        String langC = new String("자바");
        String langD = new String("자바");

        System.out.println("new 객체 참조 비교: " + (langC == langD));    // false
        System.out.println("new 객체 내용 비교: " + langC.equals(langD)); // true


        // 3. 빈 문자열 확인
        String emptyStr = "";
        boolean isEmpty = emptyStr.isEmpty();

        System.out.println("빈 문자열 여부: " + isEmpty); // true
    }
}