package basic.control_flow;

// break
// - 가장 가까운 반복문 하나를 즉시 탈출
// - 중첩 루프 전체를 탈출할 때는 Label을 지정해서 break 라벨명; 사용
public class BreakExample {
    public static void main(String[] args) {

        // 기본 break
        while (true) {
            int dice = (int) (Math.random() * 6) + 1;
            System.out.println("주사위: " + dice);

            if (dice == 6) {
                System.out.println("6 나와서 탈출");
                break;
            }
        }

        // Label break (바깥 루프까지 한번에 탈출)
        Outer:
        for (char upper = 'A'; upper <= 'Z'; upper++) {
            for (char lower = 'a'; lower <= 'z'; lower++) {
                System.out.println(upper + "-" + lower);

                if (lower == 'c') {
                    System.out.println("'c' 도달해서 Outer 전체 종료");
                    break Outer;
                }
            }
        }
    }
}