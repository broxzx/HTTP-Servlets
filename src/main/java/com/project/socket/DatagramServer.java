package com.project.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {

    public static void main(String[] args) throws IOException {

        try (DatagramSocket datagramSocket = new DatagramSocket(8888)) {
            byte[] buffer = new byte[512];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);

            System.out.println(new String(buffer, 0, datagramPacket.getLength()));
        }
    }
}
