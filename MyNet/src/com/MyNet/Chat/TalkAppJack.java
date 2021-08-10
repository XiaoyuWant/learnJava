package com.MyNet.Chat;

public class TalkAppJack {
    public static void main(String[] args) {
        new Thread(new TalkSender(7777,"106.14.34.53",9999)).start();
        new Thread(new TalkReceiver(44444,"Bob")).start();
    }
}
