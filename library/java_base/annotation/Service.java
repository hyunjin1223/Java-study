package library.java_base.annotation;

public class Service {

    @PrintInfo
    public void start() {
        System.out.println("서비스 시작");
    }

    @PrintInfo("*")
    public void process() {
        System.out.println("서비스 처리");
    }

    @PrintInfo(value = "#", count = 5)
    public void finish() {
        System.out.println("서비스 종료");
    }
}