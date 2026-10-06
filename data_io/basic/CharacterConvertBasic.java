package data_io.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

// 문자 변환 스트림
// - InputStreamReader는 바이트 입력 스트림을 문자 입력 스트림으로 변환한다.
// - OutputStreamWriter는 문자 출력 스트림을 바이트 출력 스트림으로 변환한다.
// - 문자셋을 지정하면 원하는 인코딩 방식으로 문자를 처리할 수 있다.

public class CharacterConvertBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "utf8.txt");

        // 문자 데이터를 UTF-8로 파일에 저장
        try (OutputStream output = new FileOutputStream(file.toFile());
             Writer writer = new OutputStreamWriter(
                     output, StandardCharsets.UTF_8)) {

            writer.write("한글 데이터를 저장합니다.");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 파일의 바이트 데이터를 UTF-8 문자로 변환해서 읽기
        try (InputStream input = new FileInputStream(file.toFile());
             Reader reader = new InputStreamReader(
                     input, StandardCharsets.UTF_8)) {

            char[] buffer = new char[32];
            int count;

            System.out.println("[UTF-8 파일 읽기]");

            // 실제로 읽은 문자 수만큼 출력
            while ((count = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, count));
            }

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}