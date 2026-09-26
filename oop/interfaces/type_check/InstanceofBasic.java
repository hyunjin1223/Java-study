package oop.interfaces.type_check;

// instanceof
// - 인터페이스 타입으로 참조한 객체의 실제 타입을 확인할 수 있다.
// - 특정 구현 클래스인지 확인한 뒤 해당 타입으로 변환할 수 있다.
// - 타입에 따라 다른 기능을 사용해야 할 때 활용한다.

interface Storage {
    void save();
}

class FileStorage implements Storage {

    @Override
    public void save() {
        System.out.println("파일로 저장합니다.");
    }

    void compress() {
        System.out.println("파일을 압축합니다.");
    }
}

class CloudStorage implements Storage {

    @Override
    public void save() {
        System.out.println("클라우드에 저장합니다.");
    }
}

public class InstanceofBasic {

    public static void main(String[] args) {
        Storage storage = new FileStorage();

        // 실제 객체가 FileStorage인지 확인
        if (storage instanceof FileStorage) {

            // 확인한 뒤 구현 클래스 타입으로 변환
            FileStorage fileStorage = (FileStorage) storage;

            fileStorage.compress();
            // 파일을 압축합니다.
        }

        storage.save();
        // 파일로 저장합니다.
    }
}