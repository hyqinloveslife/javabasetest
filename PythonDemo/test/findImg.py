#coding=utf-8
'''
Created on 2017年12月8日

@author: hyqin
'''
import urllib2
import cookielib
from bs4 import BeautifulSoup
import urllib
#url = 'http://www.baidu.com'\
#url = 'http://fuliba.net/%e5%bf%83%e8%84%8f%e6%95%99%e5%ad%a6.html'
url = 'http://bbs.chongbuluo.com/forum.php?mod=viewthread&tid=3242'
# #创建request对象
# req = urllib2.Request(url)
# 
# # 添加数据
# req.add_data('a','1')
# 
# # 添加header头信息
# req.add_header('User-Agent', 'Mozilla/5.0')
# 
# res = urllib2.urlopen(url)
# res.read()

# 创建cookie容器
cj = cookielib.CookieJar()

# 创建一个opener
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))

# 给urllib2安装opener
urllib2.install_opener(opener)

# 使用带cookie的url访问网页
res = urllib2.urlopen(url)

cont = res.read()

soups = BeautifulSoup(cont,'html.parser',from_encoding='utf-8')

print '获取所有的链接'

links = soups.find_all('img',class_='zoom')
x=0
for  _index in links:
    print _index.name,_index['src']
    urllib.urlretrieve(_index['src'],'D:\EIMG\%s.jpg'%x)
    x=x+1





































