package com.MyNet.Tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpFileClient {
    public static void main(String[] args) {
        Socket socket=null;
        OutputStream os=null;
        FileInputStream fis=null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
            os = socket.getOutputStream();

            fis = new FileInputStream(new File("E:\\Record.txt"));

            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            socket.shutdownOutput();
            // 确认服务器接收完毕
            InputStream inputStream=socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while((len=inputStream.read(buffer2))!=-1){
                baos.write(buffer2,0,len);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
