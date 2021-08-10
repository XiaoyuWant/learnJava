package com.MyNet.Tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MsgOut implements Runnable{
    Socket socket;
    String name;
    public MsgOut(Socket socket,String name){
        this.socket=socket;
        this.name=name;
    }
    @Override
    public void run(){
        PrintWriter pwtoclien=null;
        try {
            pwtoclien = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner keybordscanner = new Scanner(System.in);

        while(true){
            while(keybordscanner.hasNextLine()) {

                String keyborddata = keybordscanner.nextLine();
                pwtoclien.println(name+":\t"+keyborddata);

                pwtoclien.flush();
            }
        }


    }
}
