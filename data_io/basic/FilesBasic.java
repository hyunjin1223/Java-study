package data_io.basic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

// Files 클래스
// - Path와 함께 파일과 디렉터리를 편리하게 다룰 수 있다.
// - 파일 생성, 읽기, 쓰기, 복사 등의 기능을 제공한다.
// - 간단한 파일 작업을 짧은 코드로 처리할 수 있다.

public class FilesBasic {

    public static void main(String[] args) {

        Path directory = Path.of("data", "files");
        Path source = directory.resolve("source.txt");
        Path copy = directory.resolve("copy.txt");

        try {
            // 디렉터리가 없으면 필요한 경로까지 한 번에 생성
            Files.createDirectories(directory);

            // UTF-8 형식으로 문자열을 파일에 저장
            Files.writeString(
                    source,
                    "Java 파일 입출력을 공부합니다.\nFiles 클래스를 사용합니다.",
                    StandardCharsets.UTF_8
            );

            // 파일 전체 내용을 문자열로 읽기
            String content = Files.readString(
                    source,
                    StandardCharsets.UTF_8
            );

            System.out.println("[파일 내용]");
            System.out.println(content);

            // 원본 파일을 복사
            // 같은 이름의 파일이 있으면 덮어쓴다.
            Files.copy(source, copy, StandardCopyOption.REPLACE_EXISTING);

            System.out.println();
            System.out.println("원본 존재: " + Files.exists(source));
            System.out.println("복사본 존재: " + Files.exists(copy));

            // 파일 내용을 줄 단위로 읽기
            List<String> lines = Files.readAllLines(
                    source,
                    StandardCharsets.UTF_8
            );

            System.out.println();
            System.out.println("[줄 단위 읽기]");

            // 읽은 각 줄을 하나씩 출력
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}