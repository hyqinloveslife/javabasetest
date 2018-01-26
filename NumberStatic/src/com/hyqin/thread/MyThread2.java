package com.hyqin.thread;

public class MyThread2 extends Thread {
	private String name;
	
	public MyThread2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread()+" "+ name+" : "+i);
		}
		
	}
	
}
