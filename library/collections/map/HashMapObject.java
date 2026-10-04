package library.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// HashMap과 Key 객체의 동등성
// - HashMap은 Key 객체의 hashCode()와 equals()를 이용하여 동등성을 판단한다.
// - 사용자 정의 객체를 Key로 사용할 때 동등한 객체를 같은 Key로 판단하려면
//   hashCode()와 equals()를 알맞게 재정의해야 한다.

public class HashMapObject {

    static class Student {
        private String studentId;
        private String name;

        public Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Student other)) {
                return false;
            }

            return Objects.equals(studentId, other.studentId)
                    && Objects.equals(name, other.name);
        }
    }

    public static void main(String[] args) {

        Map<Student, Integer> studentScores = new HashMap<>();

        // Key 객체 생성 및 저장
        studentScores.put(new Student("S001", "HyunJin"), 95);
        studentScores.put(new Student("S002", "MinSu"), 88);

        // 내용이 같은 새로운 Key 객체로 조회
        // hashCode()와 equals()가 재정의되어 같은 Key로 판단한다.
        Student searchKey = new Student("S001", "HyunJin");

        System.out.println("HyunJin 점수: " + studentScores.get(searchKey));
        // HyunJin 점수: 95

        // 기존 Key와 동등한 Key로 값을 저장하면 기존 값이 변경된다.
        studentScores.put(new Student("S001", "HyunJin"), 100);

        System.out.println("수정 후 HyunJin 점수: " + studentScores.get(searchKey));
        // 수정 후 HyunJin 점수: 100

        System.out.println("전체 학생 수: " + studentScores.size());
        // 전체 학생 수: 2
    }
}