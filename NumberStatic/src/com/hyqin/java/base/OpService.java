package com.hyqin.java.base;

import java.util.List;

/**
 * 
 * @author hyqin
 * 测试可变参数
 *
 */
public interface OpService {
	
	public <T> T getT(Class<T> c) throws InstantiationException, IllegalAccessException;
	
	/**
	 * @Title: complex 
	 * @Description: 可变参数的函数  
	 * @param @param t
	 * @param @return   
	 * @return List<T> 
	 * @throws
	 * @author hyqin
	 * @date 2018年2月27日$
	 */
	//TODO 可变参数的函数
	public <T> List<T> complex(T ... t);
	
}
