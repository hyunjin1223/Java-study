package basic.variables_and_types;

// String 타입, 이스케이프 문자 및 텍스트 블록 (Java 13+)
public class StringType {
    public static void main(String[] args) {

        // 1. 기본 String 변수 선언
        String title = "Java Programming";
        String author = "개발자";

        System.out.println(title);
        System.out.println(author);


        // 2. 이스케이프 문자 활용 (\", \t, \n)
        String quote = "그가 말했다. \"자바는 재밌다.\"";
        String header = "ID\t이름\t점수";

        System.out.println(quote);
        System.out.println(header);

        System.out.print("안녕하세요.\n");
        System.out.print("반갑습니다.\n");


        // 3. 텍스트 블록 (Java 13 이상)
        // """를 사용해 이스케이프 없이 여러 줄 문자열 표현
        String json = """
                {
                    "status": 200,
                    "message": "성공"
                }
                """;

        System.out.println(json);


        // 4. 텍스트 블록 내 줄바꿈 방지 (\ 사용, Java 14 이상)
        String text = """
                첫 번째 문장입니다. \
                이 문장은 이전 줄과 이어집니다.
                세 번째 문장입니다.
                """;

        System.out.println(text);
    }
}