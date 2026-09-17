package oop.inheritance.type_check;

// instanceof
// - instanceof는 참조 변수가 가리키는 실제 객체의 타입을 확인할 때 사용한다.
// - 부모 타입으로 참조한 객체가 특정 자식 타입인지 확인할 수 있다.
// - 타입을 확인한 뒤 자식 타입으로 형변환할 수 있다.

class BasicAccount {
}

class BasicSavingsAccount extends BasicAccount {

    void saveMoney() {
        System.out.println("저축합니다.");
    }
}

public class InstanceofBasic {

    public static void main(String[] args) {
        BasicAccount account = new BasicSavingsAccount();

        // 실제 객체가 BasicSavingsAccount 타입인지 확인
        if (account instanceof BasicSavingsAccount) {
            BasicSavingsAccount savings = (BasicSavingsAccount) account;
            savings.saveMoney();
            // 저축합니다.
        }
    }
}