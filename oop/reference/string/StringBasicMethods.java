package oop.reference.string;

// String 기본 메서드
// - charAt(): 특정 위치의 문자를 반환
// - length(): 문자열의 길이를 반환
// - replace(): 특정 문자열을 다른 문자열로 변경
// - substring(): 문자열의 일부분을 추출
public class StringBasicMethods {
    public static void main(String[] args) {

        // 1. charAt() - 특정 위치의 문자 확인
        String text = "Java";
        char first = text.charAt(0);
        char third = text.charAt(2);

        System.out.println("첫 번째 문자: " + first);   // J
        System.out.println("세 번째 문자: " + third);   // v


        // 2. length() - 문자열 길이 확인
        String language = "Java Programming";
        System.out.println("문자열 길이: " + language.length()); // 16


        // 3. replace() - 문자열 변경
        String original = "I like Python.";
        String changed = original.replace("Python", "Java");

        System.out.println("원본: " + original);   // I like Python.
        System.out.println("변경: " + changed);    // I like Java.


        // 4. substring() - 문자열 일부 추출
        String productCode = "2026-JAVA-99";

        String year = productCode.substring(0, 4);
        String category = productCode.substring(5, 9);
        String number = productCode.substring(10);

        System.out.println("연도: " + year);       // 2026
        System.out.println("분류: " + category);   // JAVA
        System.out.println("번호: " + number);     // 99
    }
}