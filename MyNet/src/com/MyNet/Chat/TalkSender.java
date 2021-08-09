package com.MyNet.Chat;

import javax.print.attribute.standard.RequestingUserName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSender implements Runnable {
    DatagramSocket socket=null;
    BufferedReader reader=null;
    private String fromIp;
    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSender(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            socket=new DatagramSocket(this.fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        reader=new BufferedReader(new InputStreamReader(System.in));


    }


//    try {
//        socket=new DatagramSocket(8888);
//    } catch (
//    SocketException e) {
//        e.printStackTrace();
//    }
    @Override
    public void run(){
        while(true){
            String data= null;
            try {
                data = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] datas = data.getBytes();
            DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIp,this.toPort));
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(data.equals("bye")){
                break;
            }
        }

    }

}
