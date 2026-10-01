package library.java_base.system_class;

// System.in을 이용한 키보드 입력
// - System.in은 키보드 입력을 받는 스트림이다.
// - read()는 입력된 키 하나를 읽어 코드값으로 반환한다.
// - Enter를 누르기 전까지의 입력을 한 번에 읽는 것은 아니다.

public class KeyInput {

    public static void main(String[] args) throws Exception {

        System.out.print("키를 입력하세요: ");

        // 입력한 키의 코드값 저장
        int keyCode = System.in.read();

        System.out.println("입력한 키 코드: " + keyCode);
        // 예: a -> 97
    }
}