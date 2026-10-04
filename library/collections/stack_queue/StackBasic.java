package library.collections.stack_queue;

import java.util.Stack;

// Stack 기본
// - Stack은 LIFO(Last In First Out) 방식으로 데이터를 처리한다.
// - 나중에 추가한 객체가 먼저 나온다.
// - push()로 객체를 넣고 pop()으로 가장 위의 객체를 꺼낸다.

public class StackBasic {

    public static void main(String[] args) {

        Stack<String> history = new Stack<>();

        // 방문 기록 저장
        history.push("Home");
        history.push("Search");
        history.push("Product");
        history.push("Checkout");

        // 가장 최근에 저장한 기록부터 가져온다.
        while (!history.isEmpty()) {
            String page = history.pop();

            System.out.println("뒤로 이동: " + page);
        }

        // 뒤로 이동: Checkout
        // 뒤로 이동: Product
        // 뒤로 이동: Search
        // 뒤로 이동: Home
    }
}