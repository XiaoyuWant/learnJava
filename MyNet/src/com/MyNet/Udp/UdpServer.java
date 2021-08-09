package com.MyNet.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) {
        DatagramSocket socket=null;
        try {
            socket = new DatagramSocket(9090);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[1024];
        DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);
        try {
            socket.receive(packet);
            System.out.println(packet.getAddress());
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
