package basic.variables_and_types;

// 변수 선언, 초기화, 값 교환 개념
public class VariableDeclaration {
    public static void main(String[] args) {

        // 변수 선언 및 초기화
        int age;
        age = 22;

        double height = 175.5;

        // 초기화하지 않은 변수는 연산에 사용 불가 (컴파일 에러)
        // int count;
        // int total = count + 1;


        // 변수 활용
        int speed = 60;
        int time = 2;
        int distance = speed * time;

        System.out.println("이동 거리: " + distance + "km");


        // 두 변수의 값 교환 (Swap)
        int x = 10;
        int y = 20;

        int temp = x; // x의 값을 temp에 임시 저장
        x = y;        // x에 y의 값 대입
        y = temp;     // y에 temp 값 대입

        System.out.println("x: " + x + ", y: " + y);
    }
}