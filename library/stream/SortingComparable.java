package library.stream;

import java.util.Comparator;
import java.util.List;

// Comparable을 이용한 정렬
// - 클래스가 기본 정렬 기준을 직접 정의할 수 있다.
// - compareTo()가 정의한 기준으로 요소를 정렬한다.
// - sorted()는 Comparable을 구현한 요소를 정렬할 수 있다.

public class SortingComparable {

    record Movie(String title, int rating) implements Comparable<Movie> {

        @Override
        public int compareTo(Movie other) {
            return Integer.compare(rating, other.rating);
        }
    }

    public static void main(String[] args) {

        List<Movie> movies = List.of(
                new Movie("Interstellar", 9),
                new Movie("Arrival", 8),
                new Movie("Dune", 10),
                new Movie("Gravity", 7)
        );

        // 평점을 기준으로 오름차순 정렬
        movies.stream()
                .sorted()
                .forEach(movie ->
                        System.out.println(movie.title() + ": " + movie.rating()));

        System.out.println();

        // 기본 정렬 기준을 반대로 적용
        movies.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(movie ->
                        System.out.println(movie.title() + ": " + movie.rating()));
    }
}