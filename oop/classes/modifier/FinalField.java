package oop.classes.modifier;

// final 필드
// - final 필드는 한 번 값을 지정하면 다시 변경할 수 없다.
// - 선언할 때 값을 넣거나 생성자에서 한 번 초기화할 수 있다.
// - 객체마다 다른 값을 가지면서 변경되면 안 되는 값은 생성자에서 초기화할 수 있다.
public class FinalField {
    final String name;
    final int id;

    // 생성될 때 final 필드의 값을 한 번 지정
    FinalField(String name, int id) {
        this.name = name;
        this.id = id;
    }
}