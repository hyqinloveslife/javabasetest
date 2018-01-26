package com.hyqin.net;

import java.io.InputStream;
/**
 * 网络工具类
 * @author hyqin
 *
 */
public class HttpUtils {
	/**
	 * 从流里面获取内容 转成String
	 * @param is 输入流
	 * @return 字符串
	 */
	public String getNetContent(InputStream is) {
		try {
			if(is!=null) {
				byte [] b = new byte [1024];
				int len = is.read(b);
				return new String(b,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 写入内容到流
	 * @param content
	 * @return
	 */
	public byte [] writeContent(String content) {
		byte[] b = new byte[1024];
		try {
			if(content!=null&&!content.equals("")) {				
				b = content.getBytes();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
