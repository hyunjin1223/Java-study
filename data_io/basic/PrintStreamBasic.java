package data_io.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;

// 프린트 스트림
// - PrintStream은 다양한 타입의 데이터를 편리하게 출력한다.
// - print(), println(), printf()를 사용할 수 있다.
// - 문자열이나 숫자를 원하는 형식으로 출력할 때 유용하다.

public class PrintStreamBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "print.txt");

        // 파일 출력 스트림에 PrintStream 연결
        try (PrintStream output = new PrintStream(
                new FileOutputStream(file.toFile()))) {

            // print()는 줄바꿈 없이 출력
            output.print("이름: ");
            output.println("HyunJin");

            // println()은 출력 후 줄바꿈
            output.print("점수: ");
            output.println(95);

            // printf()는 지정한 형식에 맞춰 출력
            output.printf("평균: %.1f%n", 91.75);

            output.println();
            output.println("[상품 정보]");

            // %,d는 숫자에 천 단위 구분 기호를 추가한다.
            output.printf("%s / %,d원%n", "Keyboard", 45000);
            output.printf("%s / %,d원%n", "Mouse", 28000);

            // 버퍼에 남아 있는 내용을 출력
            output.flush();

            System.out.println("문자열 출력 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}