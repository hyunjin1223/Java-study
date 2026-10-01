package library.java_base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션 기본
// - @interface로 새로운 어노테이션 타입을 정의한다.
// - 어노테이션은 속성을 가질 수 있고 기본값도 지정할 수 있다.
// - value라는 이름의 속성은 값을 하나만 지정할 때 이름을 생략할 수 있다.
// - @Target으로 적용 가능한 대상을 정할 수 있다.
// - @Retention으로 어노테이션 유지 범위를 정할 수 있다.

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Info {

    String value() default "기본 정보";

    int level() default 1;
}

public class AnnotationBasic {

    @Info
    static class User {

        @Info("사용자 이름")
        private String name;

        @Info(value = "사용자 소개", level = 2)
        void introduce() {
            System.out.println("안녕하세요.");
        }
    }

    public static void main(String[] args) {

        // 기본값을 그대로 사용하는 경우
        @Info
        class BasicUser {
        }

        // value 속성만 사용할 때는 이름을 생략할 수 있다.
        @Info("테스트")
        class TestUser {
        }

        // 다른 속성까지 지정할 때는 이름을 작성한다.
        @Info(value = "상세 정보", level = 5)
        class DetailUser {
        }

        System.out.println("어노테이션 선언 확인");
    }
}