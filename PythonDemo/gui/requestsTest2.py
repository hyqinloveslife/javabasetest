#coding=utf-8
# -*- coding: utf-8 -*-

import re,sys,time,imp
import urllib2
from bs4 import BeautifulSoup

class MovieComment:
    def __init__(self):
        imp.reload(sys)
        self.start = 0
        self.pages = ''
        self.param = '&limit=20&sort=new_score&status=P'
        self.headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36','cookie': 'cookie信息'}
        self.commentList = []
        self.filePath = 'sccc.txt'

    def getPage(self):
        try:
        #https://movie.douban.com/subject/25823277/comments?start=40&limit=20&sort=new_score&status=P&percent_type=    
            for _index in range(10):
                #URL = 'https://movie.douban.com/subject/25823277/comments?start=' +(_index+1)*20+'&limit=20&sort=new_score&status=P&percent_type='
                URL = 'https://movie.douban.com/subject/25823277/comments?status=P'
                request = urllib2.Request(url = URL, headers = self.headers)
                response = urllib2.urlopen(request, timeout = 30000)
                page = BeautifulSoup(response.read(),'html.parser',from_encoding='utf-8')
                #print 'page:',page
                #page = response.read().decode('utf-8')
                pageNum = (self.start + 20)/20
                print( '正在抓取第' + str(pageNum) + '页数据...' )
                self.start += 20
                self.pages=self.pages+page
                return self.pages 
        except Exception as e:
            if hasattr(e, 'reason'):
                print( '抓取失败，具体原因：', e.reason)
                #超时响应
                response = urllib2.urlopen(request,timeout = 300000)
                #page = response.read().decode("utf-8")
                page = BeautifulSoup(response.read(),'html.parser',from_encoding='utf-8')
                pageNum = (self.start + 20)/20
                print( '正在抓取第' + str(pageNum) + '页数据...' )
                self.start += 20
                return(page)
    
    def getMovie(self):
        #pattern = re.compile(u'<div.*?class="avatar">.*?'+ u'<a.*?title="(.*?)".*?href=".*?">.*?</a>.*?'+ u'<p.*?class="">(.*?)</p>',re.S)
        #pattern = re.compile(r"<div>");
        print '当前页面的值：',self.start
        page = self.getPage()
        if page is None:
            print '没有抓取到数据'
            return
        print 'page:',page
        # comments = re.findall(pattern,page)
        
        comments = page.find_all('span', class_='comment-info')
        
        # print '测试，看一下comments里面是否有数据',comments
        
        for comment in comments:
            # self.commentList.append([comment[0], comment[1].strip()])
            # #获取作者
            author = comment.find('a').get_text().encode('utf-8')
            comment_time = comment.find('span', class_='comment-time ').get_text()
            remark = comment.find('span', class_='rating')['title']
            # print 'remark:',remark
            # print author,comment_time
            comments_dict = {}
            comments_dict['author'] = author.replace(' ', '')
            comments_dict['time'] = comment_time.replace(' ', '').replace('\n', '')
            comments_dict['remark'] = remark.replace(' ', '')
            self.commentList.append(comments_dict)
    
    def writeTxt(self):
        fileComment = open(self.filePath, 'w')   ##这里的w很重要
        try:
            for comment in self.commentList:
                print comment
                ##在写入文件的时候，如果出现编码问题,就将编码改成utf-8
                fileComment.write(comment['author']+'\t'+comment['time'].encode('utf-8')+'\t'+comment['remark'].encode('utf-8') + '\n')
            print( '文件写入成功...')
        finally:
            fileComment.close()
    
    def main(self):
        print( '正在从《三生三世十里桃花》电影短评中抓取数据...')
        self.getMovie()
        self.writeTxt()
        print( '抓取完毕...')
    
DouBanSpider = MovieComment()
DouBanSpider.main()
