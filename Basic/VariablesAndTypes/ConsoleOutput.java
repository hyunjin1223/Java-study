package Basic.VariablesAndTypes;

// 콘솔 출력 서식 (printf)
public class ConsoleOutput {
    public static void main(String[] args) {
        String item = "키보드";
        int price = 89000;
        double score = 4.85;

        // 정수 자릿수 맞춤 (%d)
        System.out.printf("상품명: %s\n", item);
        System.out.printf("가격(기본): %d원\n", price);
        System.out.printf("가격(8자리 우측정렬): %8d원\n", price);
        System.out.printf("가격(8자리 0채움): %08d원\n", price);

        // 실수 소수점 지정 (%.1f, %.2f)
        System.out.printf("평점(소수점 1자리): %.1f점\n", score);
        System.out.printf("평점(소수점 2자리): %.2f점\n", score);

        // 순서 지정 인덱스 ($ 사용)
        System.out.printf("상품: %1$s, 평가점수: %2$.1f\n", item, score);
    }
}