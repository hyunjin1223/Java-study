package library.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// 스트림 기본
// - 스트림은 컬렉션이나 배열 등의 요소를 하나씩 처리하기 위한 기능이다.
// - stream()으로 스트림을 만들고 forEach()로 요소를 처리할 수 있다.
// - 스트림은 원본 데이터를 직접 변경하지 않고 요소를 처리한다.

public class StreamBasic {

    public static void main(String[] args) {

        List<String> languages = Arrays.asList(
                "Java", "Python", "JavaScript", "C++"
        );

        // 컬렉션에서 스트림 생성
        Stream<String> stream = languages.stream();

        stream.forEach(language ->
                System.out.println("언어: " + language)
        );

        System.out.println();

        // 배열에서 스트림 생성
        String[] names = {"Alice", "Bob", "Charlie"};

        Arrays.stream(names)
                .forEach(name ->
                        System.out.println("이름: " + name)
                );
    }
}