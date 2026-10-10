package data_io.network;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

// JSON 데이터 파싱
// - 파일에서 JSON 문자열을 읽고 JSONObject로 변환한다.
// - getString(), getInt(), getBoolean() 등으로 값을 가져온다.
// - 중첩 객체와 배열도 각각 JSONObject와 JSONArray로 읽을 수 있다.

public class JsonParseBasic {

    public static void main(String[] args) {

        Path file = Path.of("data", "member.json");

        try {
            // 파일 전체를 UTF-8 문자열로 읽기
            String json = Files.readString(file, StandardCharsets.UTF_8);

            // JSON 문자열을 객체로 변환
            JSONObject member = new JSONObject(json);

            // 기본 속성 읽기
            String id = member.getString("id");
            String name = member.getString("name");
            int age = member.getInt("age");
            boolean active = member.getBoolean("active");

            System.out.println("[회원 정보]");
            System.out.println("ID: " + id);
            System.out.println("이름: " + name);
            System.out.println("나이: " + age);
            System.out.println("활성 상태: " + active);

            // 중첩 객체 읽기
            JSONObject profile = member.getJSONObject("profile");

            System.out.println();
            System.out.println("[프로필]");
            System.out.println("이메일: " + profile.getString("email"));
            System.out.println("레벨: " + profile.getString("level"));

            // 배열 읽기
            JSONArray skills = member.getJSONArray("skills");

            System.out.println();
            System.out.println("[기술 목록]");

            for (int i = 0; i < skills.length(); i++) {
                System.out.println(skills.getString(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}