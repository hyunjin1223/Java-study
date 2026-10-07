package data_io.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;

// 객체 스트림
// - ObjectOutputStream은 객체를 직렬화하여 저장한다.
// - ObjectInputStream은 저장된 객체를 다시 읽어온다.
// - 객체를 저장하려면 Serializable을 구현해야 한다.
// - transient 필드는 객체 저장 대상에서 제외된다.

public class ObjectStreamBasic {

    // 직렬화 가능한 클래스
    static class Product implements Serializable {

        // 클래스 구조가 변경되었을 때 직렬화 호환성을 확인하는 값
        private static final long serialVersionUID = 1L;

        private String name;
        private int price;

        // transient 필드는 객체를 저장할 때 제외된다.
        private transient String memo;

        public Product(String name, int price, String memo) {
            this.name = name;
            this.price = price;
            this.memo = memo;
        }

        @Override
        public String toString() {
            return name + " / " + price + "원 / " + memo;
        }
    }

    public static void main(String[] args) {

        Path file = Path.of("data", "product.dat");

        // 객체를 파일에 저장
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(file.toFile()))) {

            // 객체 자체를 파일에 기록
            output.writeObject(
                    new Product("Keyboard", 45000, "배송 전 확인")
            );

            output.writeObject(
                    new Product("Mouse", 28000, "검정색")
            );

            System.out.println("객체 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // 파일에 저장된 객체를 읽기
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(file.toFile()))) {

            System.out.println("[읽은 객체]");

            // 저장된 순서대로 객체를 읽는다.
            Product first = (Product) input.readObject();
            Product second = (Product) input.readObject();

            System.out.println(first);
            System.out.println(second);

            // memo는 transient이므로 읽어온 객체에서는 null이다.

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}