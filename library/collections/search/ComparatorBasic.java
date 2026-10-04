package library.collections.search;

import java.util.Comparator;
import java.util.TreeSet;

// Comparator 기본
// - Comparator는 객체 외부에서 별도의 정렬 기준을 정의할 때 사용한다.
// - TreeSet이나 TreeMap을 생성할 때 Comparator를 전달할 수 있다.
// - 하나의 객체를 여러 기준으로 정렬해야 할 때 유용하다.

public class ComparatorBasic {

    static class Movie {
        private String title;
        private int runningTime;

        public Movie(String title, int runningTime) {
            this.title = title;
            this.runningTime = runningTime;
        }

        @Override
        public String toString() {
            return title + "(" + runningTime + "분)";
        }
    }

    public static void main(String[] args) {

        // 상영 시간이 짧은 영화부터 정렬
        Comparator<Movie> byRunningTime =
                Comparator.comparingInt((Movie movie) -> movie.runningTime)
                        .thenComparing(movie -> movie.title);

        TreeSet<Movie> movies = new TreeSet<>(byRunningTime);

        // 영화 저장
        movies.add(new Movie("Sunrise", 95));
        movies.add(new Movie("Ocean", 120));
        movies.add(new Movie("Night", 105));

        // Comparator에 정의한 기준으로 정렬
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        // Sunrise(95분)
        // Night(105분)
        // Ocean(120분)
    }
}