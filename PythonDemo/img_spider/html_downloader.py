#coding = utf-8
'''
Created on 2017年12月10日

@author: hyqin
'''
import urllib2


class HtmlDownloader(object):
    
    
    def download(self,url):
        if url is None:
            return None
        
        res = urllib2.urlopen(url)
        
        if res.getcode()!=200:
            return None
        return res.read()
    
    



