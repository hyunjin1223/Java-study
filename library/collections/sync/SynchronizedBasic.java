package library.collections.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 동기화된 컬렉션
// - Collections의 synchronizedXxx() 메소드는 기존 컬렉션을 동기화된 컬렉션으로 감싼다.
// - 여러 스레드가 동시에 컬렉션에 접근할 때 안전하게 사용할 수 있다.
// - synchronizedList(), synchronizedSet(), synchronizedMap()을 제공한다.

public class SynchronizedBasic {

    public static void main(String[] args) throws InterruptedException {

        // 동기화된 List
        List<Integer> numbers =
                Collections.synchronizedList(new ArrayList<>());

        // 동기화된 Set
        Set<Integer> uniqueNumbers =
                Collections.synchronizedSet(new HashSet<>());

        // 동기화된 Map
        Map<Integer, String> users =
                Collections.synchronizedMap(new HashMap<>());

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                numbers.add(i);
                uniqueNumbers.add(i);
                users.put(i, "User" + i);
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 1001; i <= 2000; i++) {
                numbers.add(i);
                uniqueNumbers.add(i);
                users.put(i, "User" + i);
            }
        });

        // 두 스레드 실행
        threadA.start();
        threadB.start();

        // 두 스레드가 모두 끝날 때까지 기다린다.
        threadA.join();
        threadB.join();

        System.out.println("List 크기: " + numbers.size());
        // List 크기: 2000

        System.out.println("Set 크기: " + uniqueNumbers.size());
        // Set 크기: 2000

        System.out.println("Map 크기: " + users.size());
        // Map 크기: 2000
    }
}