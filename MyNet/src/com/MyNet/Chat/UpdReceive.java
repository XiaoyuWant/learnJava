package com.MyNet.Chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UpdReceive {
    public static void main(String[] args) {
        DatagramSocket socket=null;
        try {
            socket=new DatagramSocket(6666);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while(true){
            byte[] container = new byte[1024];
            DatagramPacket packet=new DatagramPacket(container,0,container.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] data=packet.getData();
            String receiveData=new String(data,0,data.length);
            if(receiveData.equals("bye")){
                break;
            }
            System.out.println(receiveData);

        }
        socket.close();
    }
}
