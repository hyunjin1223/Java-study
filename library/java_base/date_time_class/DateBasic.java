package library.java_base.date_time_class;

import java.text.SimpleDateFormat;
import java.util.Date;

// Date 클래스
// - 날짜와 시간을 객체로 표현할 때 사용한다.
// - 현재 날짜와 시간을 가져올 수 있다.
// - SimpleDateFormat으로 원하는 형식의 문자열로 바꿀 수 있다.

public class DateBasic {

    public static void main(String[] args) {

        // 현재 날짜와 시간
        Date now = new Date();

        System.out.println("기본 출력: " + now);
        // 실행한 컴퓨터의 현재 날짜와 시간이 출력된다.

        // 원하는 형식으로 날짜 출력
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("변환 출력: " + format.format(now));
        // 예: 2026-10-01 21:30:00
    }
}