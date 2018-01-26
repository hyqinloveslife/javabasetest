package com.hyqin.thread;

public class MyThread1 extends Thread{
	private String name;
	
	public MyThread1(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		//System.out.println(Thread.currentThread()+" : "+name);
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread()+" "+ name+" : "+i);
		}
	}
	
}
