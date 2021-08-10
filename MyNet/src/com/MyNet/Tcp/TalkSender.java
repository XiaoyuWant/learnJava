package com.MyNet.Tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TalkSender{
    public static void testClient(){
        System.out.println("正在向服务器请求连接。。。");
        Socket socket = null;
//        Scanner keybordscanner = null;
//        Scanner inScanner = null;
//        PrintWriter pwtoserver = null;
        try {
            socket = new Socket("106.14.34.53", 8888);
            new Thread(new MsgIn(socket,"Alice")).start();
            new Thread(new MsgOut(socket,"Bob")).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        testClient();
    }
}
