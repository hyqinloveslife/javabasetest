package com.hyqin.net.ui;

import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
            Socket s = new Socket("127.0.0.1", 9999);

            new SendThread(s).start();
            new RecieveThread(s).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
