package com.hyqin.thread;

public class MyMain {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("张三");
		MyThread2 t2 = new MyThread2("李四");
//		t1.setPriority(1);//设置优先级 1-10
//		t1.setDaemon(false);
//		t2.setPriority(3);
		t1.start();
		t2.start();
	}
}
