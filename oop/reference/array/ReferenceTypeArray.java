package oop.reference.array;

// 참조 타입 배열
// - 배열에 객체 자체가 아니라 객체를 가리키는 참조값이 저장됨
// - String 같은 참조 타입에서 ==와 equals()의 차이를 확인할 수 있음
public class ReferenceTypeArray {
    public static void main(String[] args) {

        // 1. 참조 타입 배열 생성
        String[] languages = new String[3];

        languages[0] = "Java";
        languages[1] = "Java";
        languages[2] = new String("Java");

        // 2. 참조값 비교
        System.out.println("languages[0] == languages[1]: " +
                        (languages[0] == languages[1])
        ); // languages[0] == languages[1]: true

        System.out.println(
                "languages[0] == languages[2]: " +
                        (languages[0] == languages[2])
        ); // languages[0] == languages[2]: false

        // 3. 문자열 내용 비교
        System.out.println(
                "languages[0].equals(languages[2]): " +
                        languages[0].equals(languages[2])
        ); // languages[0].equals(languages[2]): true
    }
}