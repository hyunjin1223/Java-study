package library.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Iterator 기본
// - Iterator는 컬렉션의 객체를 하나씩 가져올 수 있는 반복자다.
// - hasNext()로 다음 객체가 있는지 확인한다.
// - next()로 다음 객체를 가져온다.
// - remove()로 마지막으로 가져온 객체를 삭제할 수 있다.

public class IteratorBasic {

    public static void main(String[] args) {

        Set<String> tools = new HashSet<>();

        tools.add("IntelliJ");
        tools.add("Git");
        tools.add("Docker");
        tools.add("VS Code");

        Iterator<String> iterator = tools.iterator();

        while (iterator.hasNext()) {

            String tool = iterator.next();

            System.out.println(tool);

            // Docker는 Iterator를 이용하여 삭제한다.
            if (tool.equals("Docker")) {
                iterator.remove();
            }
        }

        System.out.println();
        System.out.println("삭제 후: " + tools);
    }
}