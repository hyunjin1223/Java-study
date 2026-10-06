package data_io.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

// 기본 타입 스트림
// - DataOutputStream은 기본 타입 데이터를 바이트 스트림에 기록한다.
// - DataInputStream은 저장된 데이터를 원래 타입으로 읽을 수 있다.
// - 데이터를 읽는 순서는 저장할 때의 순서와 같아야 한다.

public class DataStreamBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "primitive.dat");

        // 기본 타입 데이터를 파일에 저장
        try (DataOutputStream output = new DataOutputStream(
                new FileOutputStream(file.toFile()))) {

            // 저장할 때의 순서가 중요하다.
            output.writeUTF("HyunJin");
            output.writeInt(20);
            output.writeDouble(95.5);
            output.writeBoolean(true);

            output.writeUTF("Java");
            output.writeInt(100);
            output.writeDouble(88.5);
            output.writeBoolean(false);

            System.out.println("기본 타입 데이터 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // 파일에 저장된 기본 타입 데이터를 읽기
        try (DataInputStream input = new DataInputStream(
                new FileInputStream(file.toFile()))) {

            System.out.println("[읽은 데이터]");

            // 저장된 데이터가 2개이므로 두 번 읽는다.
            for (int i = 0; i < 2; i++) {

                // 저장할 때와 같은 순서와 타입으로 읽어야 한다.
                String name = input.readUTF();
                int age = input.readInt();
                double score = input.readDouble();
                boolean passed = input.readBoolean();

                System.out.println(
                        name + " / " + age + " / " + score + " / " + passed
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}