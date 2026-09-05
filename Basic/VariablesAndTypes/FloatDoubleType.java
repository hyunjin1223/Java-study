package Basic.VariablesAndTypes;

// 실수 타입 (float, double) 및 정밀도
public class FloatDoubleType {
    public static void main(String[] args) {

        // 기본 실수 리터럴은 double로 간주되므로 float에는 F/f 접미사 필요
        double piDouble = 3.141592;
        float piFloat = 3.141592f;


        // 지수 표기법 (e/E)
        double exp1 = 1.5e3;   // 1.5 * 10^3 = 1500.0
        double exp2 = 3e-4;    // 3.0 * 10^-4 = 0.0003

        System.out.println("exp1: " + exp1);
        System.out.println("exp2: " + exp2);


        // 정밀도(유효 자릿수) 비교
        float fVal = 0.123456789f;
        double dVal = 0.123456789;

        System.out.println("float 정밀도: " + fVal);   // 약 7자리까지 표현
        System.out.println("double 정밀도: " + dVal);  // 약 15자리 이상 표현
    }
}