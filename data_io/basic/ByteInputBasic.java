package data_io.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

// 바이트 입력 스트림
// - InputStream은 바이트 데이터를 입력받는 최상위 클래스다.
// - read()는 1바이트씩 읽고, read(byte[])는 여러 바이트를 한 번에 읽는다.
// - 더 이상 읽을 데이터가 없으면 -1을 반환한다.

public class ByteInputBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "output.bin");

        try (InputStream input = new FileInputStream(file.toFile())) {

            System.out.println("[1바이트씩 읽기]");

            int data;
            // 1바이트를 읽어 반환값을 저장
            while ((data = input.read()) != -1) {
                System.out.println(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try (InputStream input = new FileInputStream(file.toFile())) {

            System.out.println("[배열로 읽기]");

            byte[] buffer = new byte[4];
            int count;

            // 읽은 바이트 수를 count에 저장
            while ((count = input.read(buffer)) != -1) {
                // 실제로 읽은 만큼만 출력
                for (int i = 0; i < count; i++) {
                    System.out.println(buffer[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}