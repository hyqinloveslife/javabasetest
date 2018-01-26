package com.hyqin.net.ui;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("监听端口号：9999");
			Socket s = ss.accept();

			new SendThread(s).start();
			new RecieveThread(s).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
