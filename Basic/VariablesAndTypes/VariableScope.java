package Basic.VariablesAndTypes;

// 변수의 유효 범위 (Scope)
public class VariableScope {
    public static void main(String[] args) {
        int age = 25; // main 메서드 전체에서 사용 가능

        if (age >= 20) {
            int rate = 10; // if 블록 내부에서만 사용 가능
            System.out.println("할인율: " + rate + "%");
        }

        // System.out.println(rate); // 에러: rate는 if 블록 밖에서 접근 불가!
    }
}