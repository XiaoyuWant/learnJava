package com.MyNet.Tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        FileOutputStream fos = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        try {
            serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();
            is = socket.getInputStream();

            // Pipe stream
            fos = new FileOutputStream(new File("E:\\out.txt"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            // 通知客户端接受已经完毕
            OutputStream os = socket.getOutputStream();
            os.write("Done.".getBytes());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
