package com.MyNet.Chat;

public class TalkAppJack {
    public static void main(String[] args) {
        new Thread(new TalkSender(7777,"localhost",9999)).start();
        new Thread(new TalkReceiver(8888,"Bob")).start();
    }
}
