package data_io.network.chat;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

// TCP 채팅 서버
// - ServerSocket으로 클라이언트의 연결을 기다린다.
// - 스레드풀을 이용해 여러 클라이언트의 통신을 처리한다.
// - 접속 중인 클라이언트 목록을 관리하고 메시지를 전달한다.

public class ChatServerBasic {

    private static final int PORT = 50002;

    private ServerSocket serverSocket;
    private volatile boolean running;

    // 접속한 클라이언트들을 안전하게 관리
    private final Set<ChatSession> clients = ConcurrentHashMap.newKeySet();

    // 최대 100개의 스레드로 클라이언트 통신 작업 처리
    private final ExecutorService threadPool =
            Executors.newFixedThreadPool(100);

    // 서버 시작
    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        running = true;

        Thread acceptThread = new Thread(this::acceptClients, "chat-accept");
        acceptThread.start();

        System.out.println("[서버] 시작됨 (포트: " + PORT + ")");
    }

    // 클라이언트 연결을 반복해서 수락
    private void acceptClients() {
        while (running) {
            try {
                Socket socket = serverSocket.accept();

                System.out.println("[서버] 연결 요청: " + socket.getRemoteSocketAddress());

                threadPool.execute(() -> handleClient(socket));

            } catch (SocketException e) {
                if (running) {
                    System.err.println("[서버 오류] " + e.getMessage());
                }
                break;

            } catch (RejectedExecutionException e) {
                // 서버 종료 중 작업이 거부되면 연결을 닫는다.
                System.out.println("[서버] 새로운 작업을 등록할 수 없습니다.");

            } catch (IOException e) {
                if (running) {
                    System.err.println("[서버 오류] " + e.getMessage());
                }
            }
        }
    }

    // 접속한 클라이언트의 통신 처리
    private void handleClient(Socket socket) {
        try {
            new ChatSession(this, socket).run();

        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ignored) {
            }

            if (running) {
                System.err.println("[클라이언트 연결 오류] " + e.getClass().getSimpleName());
            }
        }
    }

    // 새 클라이언트를 채팅 목록에 등록
    void clientJoined(ChatSession client) {
        if (clients.add(client)) {
            System.out.println("[서버] 입장: " + client.getName());
            broadcast(client, "system", "SERVER",
                    client.getName() + "님이 입장했습니다.");
        }
    }

    // 연결이 종료된 클라이언트 제거
    void clientLeft(ChatSession client) {
        if (clients.remove(client)) {
            System.out.println("[서버] 퇴장: " + client.getName());

            if (running) {
                broadcast(client, "system", "SERVER",
                        client.getName() + "님이 퇴장했습니다.");
            }
        }
    }

    // 다른 클라이언트에게 채팅 메시지 전달
    void broadcastMessage(ChatSession sender, String message) {
        broadcast(sender, "message", sender.getName(), message);
    }

    // 접속자들에게 JSON 메시지 전달
    private void broadcast(
            ChatSession sender, String type, String name, String message) {

        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("name", name);
        json.put("message", message);

        String data = json.toString();

        for (ChatSession client : clients) {
            if (client == sender) {
                continue;
            }

            try {
                client.send(data);
            } catch (IOException e) {
                client.close();
            }
        }
    }

    boolean isRunning() {
        return running;
    }

    // 서버와 접속 중인 클라이언트 종료
    public void stop() {
        running = false;

        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println("[서버 종료 오류] " + e.getMessage());
        }

        for (ChatSession client : clients) {
            client.close();
        }

        threadPool.shutdownNow();
        System.out.println("[서버] 종료됨");
    }

    public static void main(String[] args) {
        ChatServerBasic server = new ChatServerBasic();

        try {
            server.start();

            System.out.println("서버를 종료하려면 q를 입력하세요.");

            try (Scanner scanner = new Scanner(System.in)) {
                while (scanner.hasNextLine()) {
                    if (scanner.nextLine().trim().equalsIgnoreCase("q")) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("[서버 실행 오류] " + e.getMessage());

        } finally {
            server.stop();
        }
    }
}