package library.java_base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 실행 중에도 어노테이션 정보를 확인할 수 있도록 RUNTIME으로 유지
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintInfo {

    // 출력할 문구
    String value() default "-";

    // 문구를 몇 번 출력할지 지정
    int count() default 1;
}