package com.MyNet.Chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceiver implements Runnable{
    DatagramSocket socket=null;
    private int port;
    private String msgFrom;

    public TalkReceiver(int port,String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket=new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
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
            System.out.println(this.msgFrom+":"+receiveData);
        }
        socket.close();
    }
}
