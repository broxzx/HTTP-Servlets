package com.project.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
//        http - 80
//        https - 443
//        tcp
        InetAddress inetAddress = Inet4Address.getByName("localhost");

        try (Socket socket = new Socket(inetAddress, 8888);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                outputStream.writeUTF(request);
                String response = inputStream.readUTF();
                System.out.printf("Response from Server: %s%n", response);
            }

        }
    }
}
