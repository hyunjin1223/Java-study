package library.collections.map;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

// Properties 기본
// - Properties는 Hashtable을 상속한 클래스다.
// - 문자열 형태의 키와 값을 관리하는 데 주로 사용한다.
// - 설정 정보를 저장하거나 읽어오는 용도로 활용할 수 있다.
// - load()로 프로퍼티 형식의 데이터를 읽고 getProperty()로 값을 가져올 수 있다.
// - StringReader는 try-with-resources를 사용하여 자동으로 닫는다.

public class PropertiesBasic {

    public static void main(String[] args) {

        String config = """
                language=ko
                theme=dark
                fontSize=16
                """;

        Properties properties = new Properties();

        // try-with-resources로 StringReader 자원을 자동으로 해제한다.
        try (StringReader reader = new StringReader(config)) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 키를 이용해서 값 가져오기
        String language = properties.getProperty("language");
        String theme = properties.getProperty("theme");
        String fontSize = properties.getProperty("fontSize");

        System.out.println("언어: " + language);
        // 언어: ko

        System.out.println("테마: " + theme);
        // 테마: dark

        System.out.println("글자 크기: " + fontSize);
        // 글자 크기: 16

        // 존재하지 않는 키는 기본값을 지정할 수 있다.
        String timezone = properties.getProperty("timezone", "Asia/Seoul");

        System.out.println("시간대: " + timezone);
        // 시간대: Asia/Seoul
    }
}