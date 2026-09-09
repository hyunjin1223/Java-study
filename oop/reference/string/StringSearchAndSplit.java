package oop.reference.string;

// String 탐색 및 분할 메서드
// - indexOf(): 특정 문자열의 시작 위치를 반환 (없으면 -1)
// - contains(): 특정 문자열의 포함 여부를 boolean으로 반환
// - split(): 구분자를 기준으로 문자열을 나누어 String 배열로 반환
public class StringSearchAndSplit {
    public static void main(String[] args) {

        String title = "자바 프로그래밍 입문";

        // 1. indexOf() - 문자열의 위치 찾기
        int index = title.indexOf("프로그래밍");

        System.out.println("'프로그래밍' 시작 위치: " + index); // 3


        // 2. contains() - 문자열 포함 여부 확인
        boolean containsJava = title.contains("자바");

        System.out.println("'자바' 포함 여부: " + containsJava); // true


        // 3. split() - 구분자를 기준으로 문자열 분리
        String csvData = "1,공지사항,참조 타입 String을 학습합니다.,백현진";
        String[] columns = csvData.split(",");

        for (String column : columns) {
            System.out.println(column);
        }

        // 1
        // 공지사항
        // 참조 타입 String을 학습합니다.
        // 백현진
    }
}