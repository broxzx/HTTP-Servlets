package com.project.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8888);
             Socket accept = serverSocket.accept();
             DataInputStream inputStream = new DataInputStream(accept.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(accept.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {
            String request = inputStream.readUTF();

            while (!request.equals("stop")) {
                System.out.printf("Client request %s%n", request);
                String string = scanner.nextLine();
                outputStream.writeUTF(string);
                request = inputStream.readUTF();
            }

        }
    }
}
