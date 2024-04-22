package com.project.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
//        http - 80
//        https - 443
//        tcp
        InetAddress inetAddress = Inet4Address.getByName("google.com");
        try (Socket socket = new Socket(inetAddress, 80);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeUTF("Hello World"); // send request with meta data
            byte[] response = inputStream.readAllBytes();// read response from server

            System.out.println(response.length);
        }
    }
}
