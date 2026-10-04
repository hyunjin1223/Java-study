package library.multithreading.control;

// 데몬 스레드
// - 데몬 스레드는 일반 스레드를 보조하는 역할을 한다.
// - 모든 일반 스레드가 종료되면 JVM 종료와 함께 데몬 스레드도 종료된다.
// - setDaemon(true)는 스레드를 시작하기 전에 호출해야 한다.

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        // 자동 저장 기능을 수행하는 데몬 스레드
        Thread autoSave = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("자동 저장");
                } catch (InterruptedException e) {
                    // 인터럽트 상태를 다시 설정하고 종료한다.
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "AutoSave");

        // 데몬 스레드로 설정
        // - 반드시 start() 호출 전에 설정해야 한다.
        autoSave.setDaemon(true);

        // 데몬 스레드 시작
        autoSave.start();

        // 메인 스레드가 3초 동안 실행된다.
        Thread.sleep(3000);

        // 메인 스레드가 종료되면 일반 스레드가 남아 있지 않아
        // JVM이 종료되고 데몬 스레드도 함께 종료된다.
        System.out.println("메인 스레드 종료");
    }
}