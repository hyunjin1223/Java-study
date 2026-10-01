package library.java_base.format_class;

import java.text.DecimalFormat;

// DecimalFormat
// - 숫자를 원하는 형태의 문자열로 바꿀 때 사용한다.
// - 0은 자릿수를 반드시 표시하고, #은 값이 있을 때만 표시한다.

public class DecimalFormatBasic {

    public static void main(String[] args) {

        double price = 9876543.21;

        // 천 단위 구분 + 정수 부분만 표시
        DecimalFormat integerFormat = new DecimalFormat("#,###");
        System.out.println("정수: " + integerFormat.format(price));

        // 소수점 한 자리까지 표시
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        System.out.println("소수: " + decimalFormat.format(price));

        // 소수점 둘째 자리까지 표시
        DecimalFormat moneyFormat = new DecimalFormat("#,##0.00");
        System.out.println("금액: " + moneyFormat.format(price));
    }
}