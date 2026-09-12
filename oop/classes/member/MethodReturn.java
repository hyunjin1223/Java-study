package oop.classes.member;

// return
// - return은 메소드의 실행을 끝내고 결과값을 호출한 곳으로 돌려준다.
// - 반환할 값이 있다면 return 뒤에 값을 작성한다.
// - void 메소드에서도 return;을 사용하면 현재 메소드의 실행을 바로 끝낼 수 있다.
// - return이 실행되면 그 아래의 코드는 실행되지 않는다.
public class MethodReturn {

    // 전달받은 경험치에 따라 레벨을 계산해서 반환
    int getLevel(int exp) {
        if (exp < 100) {
            return 1; // 조건에 맞으면 값을 반환하고 메소드 종료
        }

        return 2;
    }

    // 이름이 없으면 메소드를 바로 종료
    void printName(String name) {
        if (name == null) {
            return; // 반환할 값 없이 메소드 종료
        }

        System.out.println("이름: " + name);
    }

    public static void main(String[] args) {
        MethodReturn example = new MethodReturn();

        System.out.println("레벨: " + example.getLevel(80));   // 레벨: 1
        System.out.println("레벨: " + example.getLevel(150));  // 레벨: 2

        example.printName(null);          // 출력 없음
        example.printName("HyunJin");     // 이름: HyunJin
    }
}