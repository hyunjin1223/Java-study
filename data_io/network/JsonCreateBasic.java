package data_io.network;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

// JSON 데이터 생성
// - JSONObject는 이름과 값으로 구성된 JSON 객체를 만든다.
// - JSONArray는 여러 값을 순서대로 담는 JSON 배열을 만든다.
// - toString(2)는 JSON 데이터를 들여쓰기하여 보기 좋게 출력한다.

public class JsonCreateBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "member.json");

        // JSON 객체 생성 및 기본 정보 추가
        JSONObject member = new JSONObject();
        member.put("id", "dev01");
        member.put("name", "Java Learner");
        member.put("age", 20);
        member.put("active", true);

        // 중첩 JSON 객체 생성
        JSONObject profile = new JSONObject();
        profile.put("email", "dev@example.com");
        profile.put("level", "beginner");

        member.put("profile", profile);

        // JSON 배열 생성
        JSONArray skills = new JSONArray();
        skills.put("Java");
        skills.put("Python");
        skills.put("SQL");

        member.put("skills", skills);

        // JSON 객체를 문자열로 변환
        String json = member.toString(2);

        System.out.println("[생성한 JSON]");
        System.out.println(json);

        try {
            // 저장할 경로의 디렉터리가 없으면 생성
            Files.createDirectories(file.getParent());

            // JSON 문자열을 UTF-8로 파일에 저장
            Files.writeString(file, json, StandardCharsets.UTF_8);

            System.out.println();
            System.out.println("JSON 파일 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}