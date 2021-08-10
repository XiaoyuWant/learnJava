package com.MyNet.Tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TalkReceiver{

    //服务器
    public static void testServer(){
        //创建一个服务器
        System.out.println("等待客户端连接。。。");
//        PrintWriter pwtoclien = null;
//        Scanner keybordscanner = null;
//        Scanner inScanner = null;
        ServerSocket ss = null;
        Socket socket=null;
        try {
            ss = new ServerSocket(8888);
            socket = ss.accept();
            System.out.println(socket.getInetAddress()+"已成功连接到此台服务器上。");


        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new MsgOut(socket,"Alice")).start();
        new Thread(new MsgIn(socket,"Bob")).start();

    }
    public static void main(String[] args) {
        testServer();
    }
}
