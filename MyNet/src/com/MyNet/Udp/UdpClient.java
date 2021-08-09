package com.MyNet.Udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UdpClient {
    public static void main(String[] args) {
        // 建立socket
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

        } catch (SocketException e) {
            e.printStackTrace();
        }

        // 建立包
        InetAddress localhost = null;
        try {
            localhost = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int port = 9090;
        String msg="hello";
        DatagramPacket dp = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);
        // 发送包
        try {
            socket.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
    }
}
