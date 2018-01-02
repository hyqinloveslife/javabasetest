#coding=utf-8
'''
Created on 2017年12月11日
测试多线程
@author: hyqin
'''
import time
import thread

###报错了，无法实现多线程问题
def print_time(threadName,delay):
    count = 0
    while count<10:
        time.sleep(delay)
        count=count+1
        print '%s:%s'%(threadName,time.ctime(time.time()))
        
try:
    thread.start_new_thread(print_time("Thread-2", 2))
    thread.start_new_thread(print_time("Thread-1", 1))
except:
    print "Error"
    raise





