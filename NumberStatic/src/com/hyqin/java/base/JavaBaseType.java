package com.hyqin.java.base;

import org.junit.Test;
/**
 * 测试Java中的异常机制
 * @author hyqin
 *
 */
public class JavaBaseType {
	public static void main(String[] args) {
		try {
			OpImpls ops = new OpImpls();
			Phone phone = (Phone) ops.getT(Class.forName("com.hyqin.java.base.Phone"));

			//程序必须要有构造方法,并且构造方法中不能有super（）函数
			Object obj = ops.getT(Class.forName("com.hyqin.java.base.Phone"));
			//都可以打印出来phone，obj不可以获取phone里面的方法
			System.out.println(obj);
			phone.setPrice(6399);
			phone.setName("iPhone X");
			phone.setType("ride dragon 845");
			System.out.println(phone);
			
			//int result = testExce();
			//System.out.println(result);
		} catch (Exception e) {
			System.out.println("Main函数的异常: "+e.getMessage());
		}
		System.out.println("程序正常结束");
	}
	
	public static int testExce(){
		int s = 0;
		try {
			s = testExce1();
		} catch (Exception e) {
			System.out.println("testExce函数出现异常");//为什么这个地方不执行呢？
			throw new ArithmeticException(e.getMessage());
		}finally {
			System.out.println("testExce最终会执行的部分");
		}
		return s;
	}
	
	public static int testExce1(){
		int c = 0;
		try {
			int a = 6;
			int b = 0;
			c = a/b;
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.out.println("testExce1函数中出现异常");
			throw new ArithmeticException(e.getMessage());
		}finally {
			System.out.println("testExce1最终会执行的部分");
		}
		return c;
	}
	
	@Test
	public void test() {
		int a = 6;
		int b = 0;
		int c = a/b;
		System.out.println(c);
	}
	
	@Test
	public void test2() {
		int a = 6;
		int b = 0;
		try {
			int c = a/b;
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.out.println("程序出现异常,变量b不能为0");
		}
		System.out.println("程序正常结束");
	}
}
