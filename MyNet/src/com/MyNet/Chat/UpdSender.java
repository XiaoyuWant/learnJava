package com.MyNet.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UpdSender {
    public static void main(String[] args) {
        DatagramSocket socket=null;
        try {
            socket=new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        //准备数据
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String data= null;
        try {
            data = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] datas = data.getBytes();
        InetSocketAddress address = new InetSocketAddress("localhost",6666);
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,address);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();


    }
}
