package library.stream;

import java.util.Arrays;
import java.util.List;

// flatMap()을 이용한 요소 변환
// - 하나의 요소를 여러 요소로 변환할 수 있다.
// - 변환된 스트림을 하나의 스트림으로 합친다.
// - 중첩된 컬렉션을 하나의 스트림으로 만들 때 자주 사용한다.

public class FlatMappingBasic {

    public static void main(String[] args) {

        List<List<String>> groups = List.of(
                List.of("Java", "Python"),
                List.of("Spring", "React"),
                List.of("MySQL", "Redis")
        );

        // 중첩된 List를 하나의 스트림으로 변환
        groups.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println();

        // 문장을 단어 단위로 나누어 하나의 스트림으로 변환
        List<String> sentences = List.of(
                "Java stream study",
                "map and flatMap",
                "learn by practice"
        );

        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .forEach(System.out::println);
    }
}