package library.java_base.string_class;

// StringBuilder 클래스
// - 문자열을 자주 추가하거나 수정할 때 사용한다.
// - String과 달리 내부 문자열을 직접 변경할 수 있다.
// - append(), insert(), delete(), replace() 등을 사용할 수 있다.
// - 여러 메소드를 이어서 호출하는 메소드 체이닝도 가능하다.

public class StringBuilderBasic {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder("Java");

        // 문자열 뒤에 추가
        builder.append(" Programming");

        // 특정 위치에 문자열 추가
        builder.insert(5, "Basic ");

        // 일부 문자열 삭제
        builder.delete(0, 5);

        // 문자열 일부 변경
        builder.replace(0, 5, "Java");

        // String으로 변환
        String result = builder.toString();

        System.out.println(result);
        // Java Programming
    }
}