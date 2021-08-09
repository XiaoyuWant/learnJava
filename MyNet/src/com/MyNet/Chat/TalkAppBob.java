package com.MyNet.Chat;

public class TalkAppBob {



    public static void main(String[] args) {
        new Thread(new TalkSender(6666,"localhost",8888)).start();
        new Thread(new TalkReceiver(9999,"Jack")).start();
    }


}
