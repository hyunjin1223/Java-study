package library.java_base.regex_class;

import java.util.regex.Pattern;

// 정규 표현식
// - 문자열이 특정 형식에 맞는지 검사할 때 사용한다.
// - Pattern.matches()는 정규식과 전체 문자열이 일치하는지 확인한다.

public class PatternBasic {

    public static void main(String[] args) {

        // 전화번호 검사
        String phoneRegex = "(02|010)-\\d{3,4}-\\d{4}";
        String phone = "010-1234-5678";

        boolean phoneResult = Pattern.matches(phoneRegex, phone);

        System.out.println("전화번호: " + phoneResult);

        // 이메일 검사
        String emailRegex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        String email = "study@example.com";

        boolean emailResult = Pattern.matches(emailRegex, email);

        System.out.println("이메일: " + emailResult);

        // 잘못된 이메일 확인
        String wrongEmail = "study@example";
        System.out.println("잘못된 이메일: " + Pattern.matches(emailRegex, wrongEmail));
    }
}