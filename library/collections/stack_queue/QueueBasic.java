package library.collections.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

// Queue 기본
// - Queue는 FIFO(First In First Out) 방식으로 데이터를 처리한다.
// - 먼저 추가한 객체가 먼저 나온다.
// - offer()로 객체를 넣고 poll()로 가장 먼저 들어온 객체를 꺼낸다.

public class QueueBasic {

    public static void main(String[] args) {

        Queue<String> tasks = new LinkedList<>();

        // 작업을 큐에 추가
        tasks.offer("파일 업로드");
        tasks.offer("메일 전송");
        tasks.offer("백업 실행");
        tasks.offer("로그 저장");

        // 먼저 들어온 작업부터 처리한다.
        while (!tasks.isEmpty()) {
            String task = tasks.poll();

            System.out.println("작업 처리: " + task);
        }

        // 작업 처리: 파일 업로드
        // 작업 처리: 메일 전송
        // 작업 처리: 백업 실행
        // 작업 처리: 로그 저장
    }
}