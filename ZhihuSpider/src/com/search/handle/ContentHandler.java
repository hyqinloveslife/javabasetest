package com.search.handle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.search.download.UrlDownload;

/**
 * 内容处理
 * @author hyqin
 *
 */
public class ContentHandler {
	
	public String getElementByContent(String content){
		Document doc = Jsoup.parse(content);
		Elements elem = doc.select("img");
		if(elem!=null) {
			int okeyNum = Integer.parseInt(elem.text());
		}
		return "";
	}
	
	
	
	@Test
	public void test() {
		String str = UrlDownload.getContentFromUrl(UrlDownload.getLocalUrl());
		System.out.println(str);
	}
}
