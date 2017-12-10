#coding:utf-8
'''
Created on 2017年12月8日

@author: hyqin
'''

def changeme(mylist):
    mylist.append([1,2,3,4])
    print "函数内取值 ：",mylist
    return

mylist = [10,20,30]
changeme(mylist)
print "函数外取值：",mylist


# 不定长参数
def printInfo(arg1,*vartuple):
    print '输出'
    print arg1
    for _index in vartuple:
        print _index
    return

print(5)  ##如果只有一个参数
print (10,20)
print(1,2,3,4,5,6,7,8,9)


# lambda只是一个表达式，函数体比def简单很多。 
totals = lambda arg1,arg2,arg3,arg4:arg1+arg2+arg3+arg4;

print 'lambda表达式 ： ',totals(1,2,3,4)
print 'lambda表达式: ',totals(4,5,6,7)


content = raw_input("(1/0)")
print '您输入的是 ： ',content



























































