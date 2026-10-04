package library.multithreading.basic;

// Thread 상속으로 스레드 생성
// - Thread 클래스를 상속하면 직접 작업 스레드를 만들 수 있다.
// - run()을 재정의하여 스레드가 실행할 작업을 정의한다.
// - 객체를 생성한 뒤 start()를 호출하면 run()이 새로운 스레드에서 실행된다.
// - 자바의 단일 상속 제약 때문에 다른 클래스를 상속받고 있다면 이 방식을 사용할 수 없다.

public class ThreadSubclass {

    static class WorkerThread extends Thread {

        @Override
        public void run() {

            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + " 실행: " + i);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {

        // Thread를 상속한 작업 스레드 생성
        WorkerThread thread = new WorkerThread();

        // 스레드 이름 설정
        thread.setName("Worker");

        // 작업 스레드 시작
        thread.start();

        // 메인 스레드 작업
        for (int i = 1; i <= 5; i++) {
            System.out.println("main 실행: " + i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}