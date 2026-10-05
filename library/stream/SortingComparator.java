package library.stream;

import java.util.Comparator;
import java.util.List;

// Comparator를 이용한 정렬
// - 클래스 외부에서 원하는 정렬 기준을 정할 수 있다.
// - sorted()에 Comparator를 전달하면 해당 기준으로 정렬한다.
// - 하나의 객체를 여러 기준으로 정렬할 때 유용하다.

public class SortingComparator {

    record Game(String title, int price, double rating) {
    }

    public static void main(String[] args) {

        List<Game> games = List.of(
                new Game("Minecraft", 30000, 4.8),
                new Game("Stardew Valley", 16000, 4.9),
                new Game("Hades", 24000, 4.7)
        );

        // 가격 기준 오름차순
        games.stream()
                .sorted(Comparator.comparingInt(Game::price))
                .forEach(game ->
                        System.out.println(game.title() + ": " + game.price()));

        System.out.println();

        // 평점 기준 내림차순
        games.stream()
                .sorted(Comparator.comparingDouble(Game::rating).reversed())
                .forEach(game ->
                        System.out.println(game.title() + ": " + game.rating()));
    }
}