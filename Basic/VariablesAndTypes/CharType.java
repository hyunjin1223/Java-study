package Basic.VariablesAndTypes;

// char 타입과 유니코드
public class CharType {
    public static void main(String[] args) {

        // 문자 직접 대입 (작은따옴표 사용)
        char letter = 'B';
        char korean = '한';

        // 유니코드 정수값 대입
        char code1 = 66;      // 'B'
        char code2 = 0x0042;  // 16진수로 표현한 'B'

        System.out.println(letter);
        System.out.println(korean);
        System.out.println(code1);


        // 빈 문자는 대입 불가, 공백 문자로 초기화 필요
        // char empty = ''; // 컴파일 에러
        char blank = ' ';
        System.out.println("공백 값: [" + blank + "]");
    }
}