package library.java_base.system_class;

import java.util.Properties;

// 시스템 프로퍼티
// - System.getProperty()로 필요한 시스템 정보를 가져올 수 있다.
// - 운영체제, 사용자 이름, 홈 디렉터리 등의 정보를 확인할 수 있다.
// - System.getProperties()로 전체 시스템 프로퍼티를 가져올 수 있다.

public class SystemProperty {

    public static void main(String[] args) {

        // 자주 사용하는 시스템 정보 확인
        System.out.println("운영체제: "
                + System.getProperty("os.name"));

        System.out.println("사용자 이름: "
                + System.getProperty("user.name"));

        System.out.println("사용자 홈: "
                + System.getProperty("user.home"));

        System.out.println();

        // 전체 시스템 프로퍼티 가져오기
        Properties properties = System.getProperties();

        // key와 value를 하나씩 출력
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);

            System.out.println(key + " = " + value);
        }
    }
}