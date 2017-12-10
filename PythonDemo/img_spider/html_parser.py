#coding=utf-8
'''
Created on 2017年12月10日

@author: hyqin
'''

import re
import urlparse
from bs4 import BeautifulSoup


class HtmlParser(object):
    
    
    def _get_new_urls(self, page_url, sp):
        new_urls = set()
        links = sp.find_all('a',href=re.compile(r"/view/\d+\.html"))
        for link in links:
            new_url = link['href']
            new_full_url = urlparse.urljoin(page_url, new_url)
            new_urls.add(new_full_url)
        return new_urls
    
    def _get_new_data(self, page_url, sp):
        res_data = {}
        
        res_data['url'] = page_url
        
        title_node = sp.find('dd',class_='aa').find('h1')
        res_data['title'] = title_node.get_text()
        
        summary_data = sp.find('div',class_='')
        res_data['summary_data'] = summary_data.get_text()
        
        return res_data
    
    
    def parse(self,page_url,html_content):
        if page_url is None or html_content is None:
            return
        
        sp = BeautifulSoup(html_content,'html_parser',from_encoding='utf-8')
        new_urls = self._get_new_urls(page_url,sp)
        new_data = self._get_new_data(page_url,sp)
        return new_urls,new_data
    
    



