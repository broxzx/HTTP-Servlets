package com.project.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = Inet4Address.getByName("localhost");

        try (DatagramSocket datagramSocket = new DatagramSocket()) {
//            ---> [buffer] <---
            byte[] buffer = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, inetAddress, 8888);

            datagramSocket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
