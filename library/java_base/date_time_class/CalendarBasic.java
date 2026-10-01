package library.java_base.date_time_class;

import java.util.Calendar;
import java.util.TimeZone;

// Calendar 클래스
// - 날짜와 시간의 각 항목을 가져올 수 있다.
// - 연도, 월, 일, 요일, 시각 등을 따로 사용할 수 있다.
// - TimeZone을 지정하면 다른 지역의 시간도 확인할 수 있다.

public class CalendarBasic {

    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "년 " + month + "월 " + day + "일");

        // 요일 확인
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);

        String[] weekNames = {"", "일", "월", "화", "수", "목", "금", "토"};

        System.out.println("요일: " + weekNames[dayOfWeek] + "요일");

        // 다른 시간대의 현재 시간
        TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar laTime = Calendar.getInstance(zone);

        int hour = laTime.get(Calendar.HOUR);
        int minute = laTime.get(Calendar.MINUTE);
        String amPm = laTime.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후";
        System.out.println("LA 시간: " + amPm + " " + hour + "시 " + minute + "분");
    }
}