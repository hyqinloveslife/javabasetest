#coding:utf-8
'''
Created on 2017年12月8日

@author: Administrator
'''
from pip._vendor import requests
from urllib2 import Request
import re
import urllib


# initUrl = 'http://www.baidu.com'

# def getHTMLtext(url):
#     try:
# #         r = requests.get(url,timeout=300)
#         r = requests.get("http://www.baidu.com", timeout=300)
#         r.raise_for_status()
#         print(r.apparent_encoding())
#         r.encoding = r.apparent_encoding()
#         return r.text
#     except:
#         return "异常"

    
##测试requests的get方法    
# r = requests.get("http://www.baidu.com", timeout=300)
# print r.text    

##想网页post一串内容
initUrl = 'http://www.baidu.com'
payload = {'key1':'value1','key2':'value2'}
# rs = requests.post('https://www.zhihu.com/collection/61633672',data = payload)
rs = requests.get('https://tieba.baidu.com/p/5470762959', timeout=30000000)
print rs.apparent_encoding
rs.encoding = rs.apparent_encoding
# print rs.text
# res_tr = r'<img .*?>(.*?)</img>'
res_tr = r'src="(.+?\.jpg)" pic_ext'
m_tr =  re.findall(res_tr,rs.text,re.S|re.M)
print '所有图片的集合', m_tr
x=0
for line in m_tr:
    filePath ="D:\\WORK\\py\\TensorFlow\\爬取树叶图片\\BS-Soup-gaijin\\"
    _element = urllib.urlretrieve(line['src'],'%s.jpg' % x) 
    f = open(filePath+'%s.jpg%x','ab')
    f.write(_element)
    print _element
    f.close()
    x=x+1













    
    