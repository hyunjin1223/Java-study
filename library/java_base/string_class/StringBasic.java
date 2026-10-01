package library.java_base.string_class;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// String 클래스
// - 문자열을 저장하고 다룰 때 사용한다.
// - String 객체의 내용은 변경할 수 없기 때문에,
//   문자열을 변경하면 새로운 String 객체가 만들어진다.
// - byte 배열과 String 사이의 변환도 할 수 있다.

public class StringBasic {

    public static void main(String[] args) {

        String text = "자바";

        // String -> byte 배열
        byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);

        System.out.println("UTF-8: " + Arrays.toString(utf8Bytes));
        // UTF-8: [-20, -98, -112, -21, -80, -108]

        // byte 배열 -> String
        String restoredText = new String(utf8Bytes, StandardCharsets.UTF_8);

        System.out.println("복원된 문자열: " + restoredText);
        // 복원된 문자열: 자바

        System.out.println();

        // 다른 문자 인코딩으로 변환
        byte[] eucKrBytes = text.getBytes(java.nio.charset.Charset.forName("EUC-KR"));

        System.out.println("EUC-KR: " + Arrays.toString(eucKrBytes));

        String restoredEucKr = new String(eucKrBytes, java.nio.charset.Charset.forName("EUC-KR"));

        System.out.println("복원된 문자열: " + restoredEucKr);
        // 복원된 문자열: 자바
    }
}