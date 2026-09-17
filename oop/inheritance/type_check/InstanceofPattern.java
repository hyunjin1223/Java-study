package oop.inheritance.type_check;

// instanceof 패턴 매칭
// - instanceof 검사와 동시에 자식 타입의 변수를 만들 수 있다.
// - 별도로 형변환하지 않아도 자식 타입의 멤버를 사용할 수 있다.
// - 기존의 instanceof + 형변환 코드를 더 간단하게 작성할 수 있다.

class PatternAccount {
}

class PatternSavingsAccount extends PatternAccount {

    void saveMoney() {
        System.out.println("저축합니다.");
    }
}

public class InstanceofPattern {

    public static void main(String[] args) {
        PatternAccount account = new PatternSavingsAccount();

        // PatternSavingsAccount인지 확인하고, 맞으면 savings 변수로 사용
        if (account instanceof PatternSavingsAccount savings) {
            savings.saveMoney();
            // 저축합니다.
        }
    }
}