package data_io.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

// 보조 스트림
// - 보조 스트림은 다른 스트림에 연결하여 추가 기능을 제공한다.
// - BufferedReader와 BufferedWriter는 입출력 성능을 높이는 데 사용한다.
// - BufferedReader는 readLine()으로 한 줄씩 읽을 수 있다.

public class BufferedStreamBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "buffered.txt");

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(file.toFile()))) {

            // 여러 줄의 데이터를 버퍼를 통해 출력
            writer.write("Java");
            writer.newLine();
            writer.write("Spring");
            writer.newLine();
            writer.write("Backend");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file.toFile()))) {

            System.out.println("[파일 내용]");

            String line;

            // 한 줄씩 읽기
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}