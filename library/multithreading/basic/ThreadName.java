package library.multithreading.basic;

// 스레드 이름 확인 및 변경
// - 모든 스레드는 이름을 가지고 있다.
// - 현재 실행 중인 스레드는 Thread.currentThread()로 가져올 수 있다.
// - getName()으로 스레드 이름을 확인할 수 있다.
// - setName() 또는 Thread 생성자의 매개변수로 스레드 이름을 지정할 수 있다.
// - 디버깅할 때 어떤 스레드가 실행 중인지 구분하는 데 유용하다.

public class ThreadName {

    public static void main(String[] args) {

        // 현재 실행 중인 메인 스레드 확인
        Thread mainThread = Thread.currentThread();

        System.out.println("현재 스레드: " + mainThread.getName());

        // 작업 스레드 3개 생성
        for (int i = 1; i <= 3; i++) {

            int number = i;

            // Thread 생성 시 이름을 지정하는 방식
            Thread worker = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 실행");
            }, "Worker-" + number);

            // setName()으로 이름을 지정할 수도 있다.
            // worker.setName("Worker-" + number);

            worker.start();
        }
    }
}