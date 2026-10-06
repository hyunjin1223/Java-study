package data_io.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

// 문자 출력 스트림
// - Writer는 문자를 출력하는 최상위 클래스다.
// - write()를 이용해 문자, 문자 배열, 문자열을 출력할 수 있다.
// - flush()는 버퍼에 남아 있는 데이터를 출력하고, close()는 스트림을 닫는다.

public class CharacterOutputBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "message.txt");

        try (Writer writer = new FileWriter(file.toFile())) {

            // 문자 하나 출력
            writer.write('A');
            writer.write('B');

            // 문자 배열 출력
            char[] letters = {'C', 'D', 'E'};
            writer.write(letters);

            // 문자열 출력
            writer.write("FGH");

            writer.flush();

            System.out.println("문자 데이터 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}