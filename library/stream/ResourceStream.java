package library.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 다양한 리소스에서 스트림 얻기
// - 컬렉션, 배열, 숫자 범위, 파일 등에서 스트림을 만들 수 있다.
// - IntStream, LongStream, DoubleStream은 기본 타입 요소를 처리한다.
// - 파일 스트림은 사용이 끝난 후 자원을 닫아야 한다.

public class ResourceStream {

    public static void main(String[] args) throws Exception {

        // 1. 컬렉션에서 스트림
        List<String> menus = Arrays.asList(
                "김치볶음밥", "라면", "돈까스"
        );

        menus.stream()
                .forEach(menu ->
                        System.out.println("메뉴: " + menu)
                );

        System.out.println();

        // 2. 배열에서 스트림
        int[] scores = {70, 85, 90, 95};

        Arrays.stream(scores)
                .forEach(score ->
                        System.out.println("점수: " + score)
                );

        System.out.println();

        // 3. 숫자 범위에서 스트림
        IntStream.range(1, 6)
                .forEach(number ->
                        System.out.println("숫자: " + number)
                );

        System.out.println();

        // 4. 랜덤 값으로 스트림
        java.util.Random random = new java.util.Random();

        random.ints(5, 1, 101)
                .forEach(number ->
                        System.out.println("랜덤: " + number)
                );

        System.out.println();

        // 5. 파일에서 스트림
        Path path = Files.createTempFile("stream-test", ".txt");

        Files.writeString(
                path,
                "Java\nPython\nJavaScript"
        );

        try (var lines = Files.lines(path)) {
            lines.forEach(line ->
                    System.out.println("파일: " + line)
            );
        } finally {
            Files.deleteIfExists(path);
        }
    }
}