package data_io.basic;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

// 문자 입력 스트림
// - Reader는 문자를 입력받는 최상위 클래스다.
// - read()는 문자 하나를 읽고, read(char[])는 여러 문자를 읽는다.
// - 더 이상 읽을 데이터가 없으면 -1을 반환한다.

public class CharacterInputBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "message.txt");

        try (Reader reader = new FileReader(file.toFile())) {

            System.out.println("[문자 하나씩 읽기]");

            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }

            System.out.println();
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new FileReader(file.toFile())) {

            System.out.println("[문자 배열로 읽기]");

            char[] buffer = new char[4];
            int count;

            // 실제로 읽은 문자 수를 count에 저장
            while ((count = reader.read(buffer)) != -1) {
                // 읽은 문자 수만큼 출력
                System.out.print(new String(buffer, 0, count));
            }

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}