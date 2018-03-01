package com.hyqin.java.base;

import java.util.ArrayList;
import java.util.List;

public class OpImpls implements OpService {

	@Override
	public <T> T getT(Class<T> c) throws InstantiationException, IllegalAccessException {
		T t  = c.newInstance();
		return t;
	}

	public void complex(String ...str) {
		String s = "";
		for (String string : str) {
			s+=string;
		}
		System.out.println(s);
	}
	
	public void complex(Integer ...integers) {
		
	}

	@Override
	public <T> List<T> complex(T... t) {
		List<T> list = new ArrayList<>();
		for (T t2 : t) {
			list.add(t2);
		}
		return list;
	}
	
}
