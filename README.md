# Java Study

자바 기본 문법부터 객체지향 프로그래밍, 입출력·네트워크, 주요 API까지 공부하며 작성한 예제 코드 저장소입니다.

각 파일은 특정 개념을 확인하는 독립 실행형 예제를 중심으로 구성했습니다. 애플리케이션이나 프레임워크 프로젝트가 아니라, 개념별 코드를 읽고 직접 실행하면서 학습하기 위한 저장소입니다.

## 개발 환경

- **JDK:** 17 이상 권장
- **IDE:** IntelliJ IDEA 권장
- **빌드 도구:** 현재 Maven 또는 Gradle을 사용하지 않습니다.
- **외부 라이브러리:** JSON 및 Lombok 예제는 별도 라이브러리 설정이 필요합니다.

Java 17 이상을 권장하는 이유는 프로젝트에서 `record`, `sealed class` / `sealed interface`, `instanceof` 패턴 매칭 등의 문법을 사용하기 때문입니다.

## 디렉터리 구조

```text
Java-study/
├── basic/                         # 기본 문법
│   ├── variables_and_types/       # 변수, 자료형, 형 변환, 콘솔 입출력
│   ├── operator/                  # 연산자
│   └── control_flow/               # 조건문과 반복문
│
├── oop/                           # 객체지향 프로그래밍
│   ├── classes/                   # 클래스, 멤버, 접근 제한자, 캡슐화, 싱글톤
│   ├── reference/                 # 배열, 참조 타입, 문자열
│   ├── inheritance/               # 상속, 오버라이딩, 다형성, 추상·봉인 클래스
│   ├── interfaces/                # 인터페이스, 다형성, 타입 변환
│   └── exception/                 # 예외 처리
│
├── data_io/                       # 입출력과 네트워크
│   ├── basic/                     # 바이트·문자 스트림, 파일, 객체 직렬화
│   └── network/                   # TCP, UDP, JSON, 클라이언트·서버 예제
│       └── chat/                  # TCP 채팅 예제
│
├── library/                       # 주요 Java API 및 관련 주제
│   ├── java_base/                 # Object, String, 날짜·시간, 정규식, 리플렉션 등
│   ├── collections/               # List, Set, Map, 큐, 정렬, 컬렉션 프레임워크
│   ├── generic/                   # 제네릭과 와일드카드
│   ├── lambda/                    # 람다식과 메서드 참조
│   ├── multithreading/            # 스레드, 동기화, 실행자 프레임워크
│   └── stream/                    # Stream API
│
└── README.md
```

## 실행 방법

### IntelliJ IDEA

1. 저장소 폴더를 프로젝트로 엽니다.
2. Project SDK를 JDK 17 이상으로 설정합니다.
3. 패키지 경로를 인식하지 못한다면 프로젝트 최상위 폴더를 `Sources Root`로 지정합니다.
4. 실행할 예제 파일을 열고 `main()` 메서드 옆 실행 아이콘을 눌러 실행합니다.

각 예제는 보통 별도의 `main()` 메서드를 가지고 있으므로, 공부하려는 개념의 파일을 개별적으로 실행하면 됩니다.

### 터미널

저장소 최상위 폴더에서 다음 명령으로 간단한 예제를 컴파일하고 실행할 수 있습니다.

```bash
javac -encoding UTF-8 -d out basic/variables_and_types/VariableDeclaration.java
java -cp out basic.variables_and_types.VariableDeclaration
```

`out/`은 컴파일 결과를 저장하는 폴더입니다. 예제에 따라 함께 컴파일해야 하는 파일이나 외부 라이브러리가 필요할 수 있습니다.

## 외부 라이브러리가 필요한 예제

아래 파일은 JDK만으로 컴파일할 수 없으며 IntelliJ IDEA의 프로젝트 라이브러리 또는 별도의 클래스패스에 의존성을 추가해야 합니다.

| 라이브러리 | 사용 목적 | 관련 파일 |
|---|---|---|
| `org.json` | JSON 객체·배열 생성 및 파싱, 채팅 메시지 처리 | `data_io/network/JsonCreateBasic.java`, `data_io/network/JsonParseBasic.java`, `data_io/network/chat/ChatClientBasic.java`, `data_io/network/chat/ChatServerBasic.java`, `data_io/network/chat/ChatSession.java` |
| Lombok | getter, `toString()`, `equals()`, `hashCode()` 등의 코드 생성 | `library/java_base/object_class/Lombok.java` |

Lombok 예제는 라이브러리 추가 외에 IDE 또는 컴파일러의 어노테이션 처리 설정도 필요할 수 있습니다. 현재 저장소에는 Maven/Gradle 의존성 설정이 포함되어 있지 않습니다.

## 파일 입출력 예제 참고

파일을 생성하는 예제는 실행 위치를 기준으로 `data/` 폴더에 결과 파일을 저장합니다. `.gitignore`에서 이 폴더를 제외하므로 실행 결과 파일은 Git에 포함되지 않습니다.

다음 예제는 실행 전에 `data/` 폴더가 있어야 합니다. 폴더가 없다면 직접 만들거나, `ByteOutputBasic`, `FileBasic`, `FilesBasic`처럼 디렉터리를 생성하는 예제를 먼저 실행하세요.

- `BufferedStreamBasic`
- `CharacterConvertBasic`
- `CharacterOutputBasic`
- `DataStreamBasic`
- `ObjectStreamBasic`
- `PrintStreamBasic`
- `JsonCreateBasic`

일부 입출력 예제는 다른 예제에서 생성한 파일을 읽습니다.

- `ByteInputBasic`을 실행하기 전에 `ByteOutputBasic`을 실행합니다.
- `CharacterInputBasic`을 실행하기 전에 `CharacterOutputBasic`을 실행합니다.
- `JsonParseBasic`을 실행하기 전에 `JsonCreateBasic`을 실행합니다.

## 학습 방식

- 파일과 클래스 이름을 통해 예제의 주제를 구분합니다.
- 코드를 직접 실행하고 출력 결과를 확인하면서 개념을 익힙니다.
- 하나의 예제에서 관련 개념을 함께 다루는 경우도 있으므로, 주석과 실행 결과를 같이 확인합니다.

이 저장소의 예제는 학습 목적의 코드입니다. 실무 프로젝트에 적용할 때는 입력값 검증, 예외 처리, 동시성, 보안 및 자원 관리 등을 사용 환경에 맞게 추가로 검토해야 합니다.
