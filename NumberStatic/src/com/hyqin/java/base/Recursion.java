package com.hyqin.java.base;

/**
 * 递归
 * @author hyqin
 *
 */
public class Recursion {
	public static void main(String[] args) {
		int a=0;
		int b = 9;
		swap(a, b);
		System.out.println(a+"   "+b);
	}
	
	/**
	 * 阶乘
	 * @param n
	 * @return
	 */
	public static int test1(int n) {
		if(n>1) {
			//阶乘的公式： n*(n-1)*...*(n-k)*...*2*1
			return n*test1(n-1);
			
		}else {
			return n;
		}
	}
	
	/**
	 * 全排列
	 * @param totalNum  总数
	 * @param pickNum  排列数
	 * @return
	 */
	public static int allSort(int totalNum,int pickNum) {
		if(totalNum<pickNum) {
			return -1;
		}
		
		int sum = 0;
		if(totalNum == pickNum) {
			return  totalNum* allSort(totalNum-1, pickNum-1);
		}else {
			
			sum = allSort(totalNum, pickNum);
		}
		
		return sum;
	}
	
	public static void swap(int a,int b) {
		int temp = 0;
		temp = a;
		a= b;
		b = temp;
	}
	
	
}
