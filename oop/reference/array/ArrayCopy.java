package oop.reference;

// 배열 복사
// - 배열은 생성한 뒤 크기를 바꿀 수 없음
// - 다른 배열을 만들어 기존 배열의 값을 복사할 수 있음
// - for 문이나 System.arraycopy()를 사용
public class ArrayCopy {
    public static void main(String[] args) {

        // 1. for 문으로 배열 복사
        int[] originalNumbers = { 10, 20, 30 };
        int[] copiedNumbers = new int[5];

        for (int i = 0; i < originalNumbers.length; i++) {
            copiedNumbers[i] = originalNumbers[i];
        }

        System.out.print("for 복사 결과: ");
        for (int number : copiedNumbers) {
            System.out.print(number + " ");
        }
        System.out.println(); // for 복사 결과: 10 20 30 0 0

        // 2. System.arraycopy()로 배열 복사
        String[] originalWords = { "java", "array", "copy" };
        String[] copiedWords = new String[5];

        System.arraycopy(
                originalWords,
                0,
                copiedWords,
                0,
                originalWords.length
        );

        System.out.print("arraycopy 결과: ");
        for (String word : copiedWords) {
            System.out.print(word + " ");
        }
        System.out.println(); // arraycopy 결과: java array copy null null
    }
}