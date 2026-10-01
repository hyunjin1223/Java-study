package library.java_base.date_time_class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// LocalDateTime 클래스
// - 날짜와 시간을 다룰 때 사용하는 현대적인 API이다.
// - 날짜와 시간 계산을 쉽게 할 수 있다.
// - 비교, 더하기, 빼기 등의 작업에 자주 사용한다.

public class LocalDateTimeBasic {

    public static void main(String[] args) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 현재 날짜와 시간
        LocalDateTime now = LocalDateTime.now();

        System.out.println("현재: " + now.format(format));

        // 날짜 계산
        LocalDateTime nextYear = now.plusYears(1);
        LocalDateTime beforeMonth = now.minusMonths(1);
        LocalDateTime nextWeek = now.plusDays(7);

        System.out.println("1년 후: " + nextYear.format(format));
        System.out.println("한 달 전: " + beforeMonth.format(format));
        System.out.println("7일 후: " + nextWeek.format(format));

        // 날짜 비교
        LocalDateTime start = LocalDateTime.of(2026, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 12, 31, 0, 0);

        if (start.isBefore(end)) {
            System.out.println("start가 더 이전입니다.");
        }

        // 두 날짜 사이의 차이
        long days = start.until(end, ChronoUnit.DAYS);

        System.out.println("두 날짜의 차이: " + days + "일");
        // 2026년 기준 364일
    }
}