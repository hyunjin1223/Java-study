package library.java_base.format_class;

import java.text.SimpleDateFormat;
import java.util.Date;

// SimpleDateFormat
// - Date 객체의 날짜와 시간을 원하는 문자열 형태로 바꿀 때 사용한다.
// - 패턴 문자를 조합해서 출력 형식을 정할 수 있다.

public class SimpleDateFormatBasic {

    public static void main(String[] args) {

        Date now = new Date();

        // 기본적인 날짜 형식
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(now));

        // 연도와 월, 일을 한글로 표시
        dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        System.out.println(dateFormat.format(now));

        // 날짜 + 시간
        dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(dateFormat.format(now));

        // 요일 출력
        dateFormat = new SimpleDateFormat("오늘은 E요일");
        System.out.println(dateFormat.format(now));
    }
}