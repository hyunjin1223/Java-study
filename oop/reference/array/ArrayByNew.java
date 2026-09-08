package oop.reference;

// 배열(Array) 생성 3 - new 연산자로 길이가 지정된 배열 생성
// - 지정한 길이만큼 힙(Heap) 영역에 공간을 확보 (new 타입[길이])
// - 생성 시 데이터 타입별 기본값으로 자동 초기화 (int: 0, double: 0.0, 참조타입: null)
public class ArrayByNew {
    public static void main(String[] args) {

        // 1. int 타입 배열 (기본값 0으로 초기화)
        int[] arr1 = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + " ");   // 0 0 0
        }
        System.out.println();

        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;                                                // 값 대입 후 교체

        // 2. double 타입 배열 (기본값 0.0으로 초기화)
        double[] arr2 = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("arr2[" + i + "] : " + arr2[i] + " "); // 0.0 0.0 0.0
        }
        System.out.println();

        // 3. String 참조 타입 배열 (기본값 null로 초기화)
        String[] arr3 = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("arr3[" + i + "] : " + arr3[i] + " "); // null null null
        }
        System.out.println();

        arr3[0] = "1월";
        arr3[1] = "2월";
        arr3[2] = "3월";                                             // 객체 참조 대입
    }
}