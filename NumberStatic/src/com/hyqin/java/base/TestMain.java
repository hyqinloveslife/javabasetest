package com.hyqin.java.base;

import java.util.List;

public class TestMain {
	public static void main(String[] args) {
		OpImpls ops = new OpImpls();
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		Phone phone3 = new Phone();
		Phone phone4 = new Phone();
		Phone phone5 = new Phone();
		List<Phone> list = ops.complex(phone1,phone2,phone3,phone4);
		System.out.println(list);
	}
}
