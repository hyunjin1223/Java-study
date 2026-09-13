package oop.classes.modifier;

// 상수(static final)
// - static final은 객체마다 만들 필요가 없는 공용 값을 저장할 때 사용한다.
// - 한 번 정한 값은 변경할 수 없다.
// - 상수 이름은 보통 대문자와 언더바(_)를 사용한다.
public class ConstantMember {

    static final String APP_NAME = "MyApp";
    static final double PI = 3.14159;
    static final int MAX_USERS = 100;
}