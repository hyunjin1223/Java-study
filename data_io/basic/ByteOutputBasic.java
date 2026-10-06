package data_io.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

// 바이트 출력 스트림
// - OutputStream은 바이트 데이터를 출력하는 최상위 클래스다.
// - write()로 데이터를 출력하고 flush()로 버퍼의 내용을 보낼 수 있다.
// - 사용이 끝난 스트림은 close()로 닫아야 한다.

public class ByteOutputBasic {

    public static void main(String[] args) {

        Path directory = Path.of("data");
        Path file = directory.resolve("output.bin");

        try {
            Files.createDirectories(directory);

            try (OutputStream output = new FileOutputStream(file.toFile())) {

                // 바이트 하나 출력
                output.write(65);

                // 바이트 배열 전체 출력
                byte[] data = {66, 67, 68, 69};
                output.write(data);

                // 배열의 일부만 출력
                byte[] extra = {70, 71, 72, 73, 74};
                output.write(extra, 1, 3);

                output.flush();
            }

            System.out.println("파일 저장 완료: " + file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}