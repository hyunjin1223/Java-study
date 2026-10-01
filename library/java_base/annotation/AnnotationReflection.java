package library.java_base.annotation;

import java.lang.reflect.Method;

// 리플렉션으로 어노테이션 정보 확인
// - Method에서 적용된 어노테이션을 가져올 수 있다.
// - RUNTIME으로 유지된 어노테이션은 실행 중에도 읽을 수 있다.
// - 가져온 어노테이션의 속성값을 이용해 원하는 동작을 추가할 수 있다.

public class AnnotationReflection {

    public static void main(String[] args) throws Exception {

        Method[] methods = Service.class.getDeclaredMethods();
        Service service = new Service();

        for (Method method : methods) {

            // 현재 메소드에 PrintInfo가 적용되어 있는지 확인
            PrintInfo printInfo = method.getAnnotation(PrintInfo.class);

            // 어노테이션이 없는 메소드는 건너뜀
            if (printInfo == null) {
                continue;
            }

            // 어노테이션에서 설정한 속성값 가져오기
            String value = printInfo.value();
            int count = printInfo.count();

            System.out.println("[메소드] " + method.getName());

            // count만큼 value 출력
            for (int i = 0; i < count; i++) {
                System.out.print(value);
            }

            System.out.println();

            // 원래 메소드 실행
            method.invoke(service);
            System.out.println();
        }
    }
}