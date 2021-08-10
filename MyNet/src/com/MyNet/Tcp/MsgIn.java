package com.MyNet.Tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MsgIn implements Runnable{
    Socket socket;
    String name;
    public MsgIn(Socket socket,String name){
        this.socket=socket;
        this.name=name;
    }

    @Override
    public void run(){
        Scanner inScanner=null;
        try {
            inScanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            while(inScanner.hasNextLine()) {
                String keyborddata = inScanner.nextLine();
                System.out.println(keyborddata);

            }
        }

    }
}
