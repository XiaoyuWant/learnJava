package com.MyNet.Chat;

public class TalkAppBob {



    public static void main(String[] args) {
        new Thread(new TalkSender(6666,"223.242.3.103",44444)).start();
        new Thread(new TalkReceiver(9999,"Jack")).start();
    }


}
