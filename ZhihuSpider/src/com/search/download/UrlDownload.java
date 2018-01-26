package com.search.download;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import com.search.utils.SpiderConstant;

public class UrlDownload {
	/**
	 * 从配置文件读取要爬虫的网站
	 * 
	 * @return
	 */
	public static String getLocalUrl() {
		Properties prop = new Properties();
		String localUrl = "";
		try {
			FileInputStream fis = new FileInputStream("url.Properties");
			prop.load(fis);
			localUrl = prop.getProperty("url");
			System.out.println(localUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return localUrl;
	}

	/**
	 * 根据url来抓取网页内容
	 * 
	 * @param url
	 * @return
	 */
	public static String getContentFromUrl(String url) {
		/* 实例化一个httpclient客户端 */
		try {
			HttpClient httpClient = new HttpClient();
			GetMethod method = new GetMethod(url);
			method.getParams().setSoTimeout(SpiderConstant.readTimeOut);
			StringBuilder contentBuilder = new StringBuilder();
			int statusCode = httpClient.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in, method.getResponseCharSet()));
				String inputLine = null;
				while((inputLine=reader.readLine())!=null) {
					contentBuilder.append(inputLine);
					contentBuilder.append("/n");
				}
				in.close();
				return convertStringCode(contentBuilder.toString(),method.getResponseCharSet(),"utf-8");
			}else {
				System.out.println("访问页面出错，返回："+method.getStatusLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 转换编码格式
	 * @param string
	 * @param responseCharSet
	 * @param string2
	 * @return
	 */
	private static String convertStringCode(String source, String responseCharSet, String charset) {
		if(source!=null&&!"".equals(source)) {
			try {
				return new String(source.getBytes(responseCharSet),charset);
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		return null;
	}

}
