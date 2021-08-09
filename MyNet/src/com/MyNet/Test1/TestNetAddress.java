package com.MyNet.Test1;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestNetAddress {
    public static void main(String[] args) {
        try {
            InetAddress netad = InetAddress.getLoopbackAddress();
            System.out.println(netad);

            InetAddress netad1 = InetAddress.getByName("www.baidu.com");
            System.out.println(netad1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
