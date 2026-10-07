package data_io.basic;

import java.io.File;
import java.io.IOException;

// File 클래스
// - 파일과 디렉터리의 정보를 확인할 수 있다.
// - 파일 생성, 삭제, 이름, 크기 등을 확인할 수 있다.
// - 파일 내용의 입출력은 스트림이나 Files 클래스를 사용한다.

public class FileBasic {

    public static void main(String[] args) {

        // data/files 디렉터리와 sample.txt 파일 객체 생성
        File directory = new File("data/files");
        File file = new File(directory, "sample.txt");

        try {
            // 디렉터리가 없으면 생성
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // 파일이 없을 때 새 파일 생성
            if (!file.exists()) {
                file.createNewFile();
            }

            // 파일의 기본 정보 확인
            System.out.println("이름: " + file.getName());
            System.out.println("경로: " + file.getPath());
            System.out.println("파일 여부: " + file.isFile());
            System.out.println("디렉터리 여부: " + file.isDirectory());
            System.out.println("크기: " + file.length() + " bytes");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}