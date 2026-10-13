package oop.exception;

// 리소스 자동 닫기
// - AutoCloseable을 구현한 객체는 try-with-resources에서 사용할 수 있다.
// - try 블록이 끝나면 예외 발생 여부와 관계없이 close()가 호출된다.

public class TryWithResources {

    static class TaskSession implements AutoCloseable {
        private final String taskName;

        public TaskSession(String taskName) {
            this.taskName = taskName;
            System.out.println("작업 준비: " + taskName);
        }

        public void execute() {
            System.out.println("작업 실행: " + taskName);
        }

        @Override
        public void close() {
            System.out.println("작업 정리: " + taskName);
        }
    }

    public static void main(String[] args) {
        // 정상적으로 끝나는 경우
        try (TaskSession session = new TaskSession("자료 정리")) {
            session.execute();
        }

        System.out.println();

        // 예외가 발생해도 리소스는 자동으로 닫힌다.
        try (TaskSession session = new TaskSession("자료 저장")) {
            session.execute();
            throw new IllegalStateException("저장 중 문제가 발생했습니다.");
        } catch (IllegalStateException e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
}