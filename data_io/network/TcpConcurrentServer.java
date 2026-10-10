package data_io.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// TCP 서버의 동시 요청 처리
// - 클라이언트의 연결을 수락하고, 요청 처리는 스레드풀에 맡긴다.
// - 스레드풀의 여러 스레드가 서로 다른 클라이언트의 작업을 처리할 수 있다.
// - 고정 스레드풀은 동시에 실행할 작업 수를 제한하고, 나머지 작업은 대기시킨다.
// - 이 예제는 클라이언트마다 메시지를 한 번 받고 응답한 뒤 연결을 종료한다.

public class TcpConcurrentServer {

    private static final int PORT = 50001;
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        // 클라이언트 요청을 처리할 스레드풀 생성
        ExecutorService clientPool = Executors.newFixedThreadPool(POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("[서버] 시작됨");
            System.out.println("포트: " + PORT);
            System.out.println("종료하려면 q를 입력하세요.");

            // 연결 수락과 클라이언트 작업 처리를 별도로 실행
            Thread acceptThread = new Thread(
                    () -> acceptClients(serverSocket, clientPool),
                    "client-acceptor"
            );
            acceptThread.start();

            // 메인 스레드는 서버 종료 명령을 기다린다.
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();

                if (command.trim().equalsIgnoreCase("q")) {
                    break;
                }
            }

            // 서버 소켓을 닫아 대기 중인 accept() 호출을 종료
            serverSocket.close();
            acceptThread.join();

        } catch (IOException e) {
            System.err.println("[서버 오류] " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // 새 작업 접수를 멈추고 처리 중인 작업의 종료를 기다린다.
            clientPool.shutdown();

            try {
                if (!clientPool.awaitTermination(5, TimeUnit.SECONDS)) {
                    // 제한 시간 내에 끝나지 않은 작업에 종료를 요청한다.
                    clientPool.shutdownNow();
                }
            } catch (InterruptedException e) {
                clientPool.shutdownNow();
                Thread.currentThread().interrupt();
            }

            System.out.println("[서버] 종료됨");
        }
    }

    // 클라이언트 연결을 수락하는 작업
    private static void acceptClients(
            ServerSocket serverSocket,
            ExecutorService clientPool
    ) {
        while (!serverSocket.isClosed()) {
            try {
                // 클라이언트가 연결될 때까지 대기
                Socket clientSocket = serverSocket.accept();

                System.out.println(
                        "[서버] 연결 수락: " + clientSocket.getRemoteSocketAddress()
                );

                // 직접 처리하지 않고 스레드풀에 작업을 등록
                // 다른 클라이언트의 연결도 계속 수락할 수 있다.
                clientPool.execute(() -> handleClient(clientSocket));

            } catch (SocketException e) {
                // 서버 종료를 위해 소켓을 닫은 경우 반복을 끝낸다.
                if (!serverSocket.isClosed()) {
                    System.err.println("[연결 수락 오류] " + e.getMessage());
                }
                break;

            } catch (IOException e) {
                System.err.println("[연결 수락 오류] " + e.getMessage());
            }
        }
    }

    // 클라이언트 한 명의 요청을 처리하는 작업
    private static void handleClient(Socket clientSocket) {
        String clientAddress =
                String.valueOf(clientSocket.getRemoteSocketAddress());

        // writeUTF()로 보낸 문자열을 readUTF()로 수신한다.
        try (Socket socket = clientSocket;
             DataInputStream input =
                     new DataInputStream(socket.getInputStream());
             DataOutputStream output =
                     new DataOutputStream(socket.getOutputStream())) {

            String message = input.readUTF();

            // 현재 작업을 처리하는 스레드 이름 확인
            String threadName = Thread.currentThread().getName();

            System.out.println(
                    "[" + threadName + "] 요청 수신: "
                            + clientAddress + " / " + message
            );

            // 받은 메시지를 바탕으로 응답 생성
            String response = "처리 완료: " + message;

            output.writeUTF(response);
            output.flush();

            System.out.println(
                    "[" + threadName + "] 응답 전송 완료: " + clientAddress
            );

        } catch (EOFException e) {
            // 클라이언트가 메시지를 보내기 전에 연결을 닫은 경우
            System.out.println(
                    "[서버] 메시지 없이 연결 종료: " + clientAddress
            );

        } catch (IOException e) {
            System.err.println(
                    "[클라이언트 처리 오류] "
                            + clientAddress + " / " + e.getMessage()
            );
        }
    }
}