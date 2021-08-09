package com.MyNet.Test1;

import java.net.InetSocketAddress;

public class TestSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress sa = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(sa);
    }
}
