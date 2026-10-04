package library.multithreading.control;

// sleep()으로 스레드 일시 정지
// - sleep()은 현재 실행 중인 스레드를 일정 시간 동안 멈춘다.
// - 지정한 시간이 지나면 다시 실행 가능한 상태가 된다.
// - sleep() 중 interrupt()가 호출되면 InterruptedException이 발생한다.

public class ThreadSleep {

    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++) {

            System.out.println("작업 " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                // 인터럽트 발생 시 인터럽트 상태를 다시 설정한다.
                Thread.currentThread().interrupt();

                break;
            }
        }

        System.out.println("작업 완료");
    }
}