package com.project.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private final ExecutorService pool;

    private final int port;

    private boolean stopped;

    public HttpServer(int port, int poolSize) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
        this.stopped = false;
    }


    public void run() {
        while (!stopped) {
            try (ServerSocket server = new ServerSocket(port)) {
                Socket socket = server.accept();
                pool.submit(() -> processSocket(socket));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {

            StringBuilder requestBuilder = new StringBuilder();
            do {
                int c = dataInputStream.read();
                requestBuilder.append((char) c);
            } while (requestBuilder.indexOf("\r\n\r\n") == -1);
            System.out.printf("Request: %s%n", requestBuilder.toString());

            byte[] bytes = Files.readAllBytes(Path.of("src", "main", "resources", "example.html"));

            String headers = """
                    HTTP/1.1 200 OK
                    content-type: application/json
                    content-length: %s
                    """.formatted(bytes.length);

            // Ensure proper newline for headers
            dataOutputStream.write((headers + "\r\n\r\n").getBytes());
            dataOutputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.stopped = true;
    }
}
