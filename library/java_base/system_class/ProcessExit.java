package library.java_base.system_class;

// System.exit()
// - 실행 중인 JVM 프로세스를 종료할 때 사용한다.
// - 매개값으로 종료 상태를 전달한다.
// - 일반적으로 0은 정상 종료를 의미한다.

public class ProcessExit {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            System.out.println(i);

            // 5가 되면 프로그램 종료
            if (i == 5) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
        }

        // 프로그램이 이미 종료되어 실행되지 않는다.
        System.out.println("끝");
    }
}