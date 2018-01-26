package com.hyqin.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class MyClient {
	
	@Test
	public void test1() {
		try {
			Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			byte [] b = new byte[1024];
			b = "i love you".getBytes();
			os.write(b);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		ServerSocket server = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			server = new ServerSocket(9999);
			socket = server.accept();
			os = socket.getOutputStream();
			is = socket.getInputStream();
			byte [] b = new byte[1024];
			int len = is.read(b);
			System.out.println("接收的内容为："+new String(b,0,len));
			os.write(b,0,len);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null) {
					socket.close();
					server.close();
				}
			} catch (Exception e2) {
				System.out.println("错误："+e2.getMessage());
			}
		}
	}
	
	@Test
	public void test() {
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			InetAddress addr2 = InetAddress.getLocalHost();
			InetAddress addr3 = InetAddress.getByName("127.0.0.1");
			System.out.println(address);
			System.out.println(addr2);
			System.out.println(addr2.getHostName()+"     "+addr2.getCanonicalHostName());
			System.out.println(addr3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
