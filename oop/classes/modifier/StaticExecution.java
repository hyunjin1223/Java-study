package oop.classes.modifier;

// 인스턴스 멤버와 static 멤버 사용
public class StaticExecution {
    public static void main(String[] args) {

        System.out.println("=== 인스턴스 멤버 ===");

        InstanceMember user = new InstanceMember("HyunJin", 20);
        user.printInfo();
        // 이름: HyunJin, 나이: 20


        System.out.println("\n=== static 멤버 ===");

        StaticMember user1 = new StaticMember();
        StaticMember user2 = new StaticMember();

        System.out.println("현재 사용자 수: " + StaticMember.userCount);
        // 현재 사용자 수: 2

        int result = StaticMember.add(30, 20);
        System.out.println("덧셈 결과: " + result);
        // 덧셈 결과: 50


        System.out.println("\n=== static 블록 ===");

        // StaticBlock의 필드에 접근하는 순간 static 블록이 실행됨
        System.out.println("프로그램: " + StaticBlock.appName);
        // static 블록 실행
        // 프로그램: MyApp

        System.out.println("버전: " + StaticBlock.version);
        // 버전: 1.0
    }
}