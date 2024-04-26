package com.project.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }


    public void run() {
        try {
            Socket accept;
            try (ServerSocket server = new ServerSocket(port)) {
                accept = server.accept();
            }

            processSocket(accept);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void processSocket(Socket accept) {
        try (accept;
             DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream())) {
            System.out.printf("Request: %s%n", new String(dataInputStream.readNBytes(400)));

            byte[] bytes = Files.readAllBytes(Path.of( "src", "main", "resources", "example.html"));

            String headers = """
                    HTTP 1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(bytes.length);

            dataOutputStream.write(headers.getBytes());
            dataOutputStream.write(System.lineSeparator().getBytes());
            dataOutputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
