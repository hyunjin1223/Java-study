package library.java_base.reflection;

import java.io.InputStream;
import java.net.URL;

// 리소스 경로 및 파일 확인
// - Class 객체를 이용하면 클래스 파일이나 리소스의 경로를 확인할 수 있다.
// - getResource()는 URL을 반환하며 상대 경로와 절대 경로를 사용할 수 있다.
// - getResourceAsStream()을 사용하면 리소스를 InputStream으로 읽을 수 있다.

public class ReflectionResource {

    public static void main(String[] args) {

        Class<?> clazz = ReflectionResource.class;

        // 현재 클래스 파일의 경로 확인
        URL classResource =
                clazz.getResource("ReflectionResource.class");

        System.out.println("[클래스 경로]");
        System.out.println(classResource);

        System.out.println();

        // 현재 패키지의 경로 확인
        URL packageResource = clazz.getResource("");

        System.out.println("[패키지 경로]");
        System.out.println(packageResource);

        System.out.println();

        // 클래스 파일을 InputStream으로 읽기
        InputStream inputStream =
                clazz.getResourceAsStream("ReflectionResource.class");

        System.out.println("[InputStream 로딩]");
        System.out.println(inputStream != null ? "리소스 읽기 성공" : "리소스 없음");
        // 리소스 읽기 성공
    }
}