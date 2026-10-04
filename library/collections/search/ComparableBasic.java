package library.collections.search;

import java.util.TreeSet;

// Comparable 기본
// - Comparable은 객체 자체가 정렬 기준을 정의할 때 사용한다.
// - compareTo()는 두 객체의 순서를 비교한다.
// - 결과가 음수면 현재 객체가 앞에 오고, 0이면 같고, 양수면 뒤에 온다.

public class ComparableBasic {

    static class Task implements Comparable<Task> {
        private String name;
        private int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            // 우선순위가 높은 작업부터 정렬
            int result = Integer.compare(other.priority, this.priority);

            // 우선순위가 같으면 이름으로 비교
            if (result == 0) {
                result = name.compareTo(other.name);
            }

            return result;
        }

        @Override
        public String toString() {
            return name + "(" + priority + ")";
        }
    }

    public static void main(String[] args) {

        TreeSet<Task> tasks = new TreeSet<>();

        // 작업 저장
        tasks.add(new Task("파일 정리", 2));
        tasks.add(new Task("서버 점검", 5));
        tasks.add(new Task("백업 확인", 3));
        tasks.add(new Task("로그 확인", 4));

        // compareTo()에 정의한 기준으로 정렬
        for (Task task : tasks) {
            System.out.println(task);
        }

        // 서버 점검(5)
        // 로그 확인(4)
        // 백업 확인(3)
        // 파일 정리(2)
    }
}