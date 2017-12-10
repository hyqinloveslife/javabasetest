# -*- coding: UTF-8 -*-
'''
Created on 2017年12月7日

@author: hyqin
'''
##一个简单的冒泡排序
from random import choice
import calendar
baseArray = [15,9,45,78,65,32,66,4,5,89]
temp=0
print '-----排序前：------'
print baseArray

for index in range(0,len(baseArray)):
    print index,'当前数字：',baseArray[index]
    for _index_j in range(index+1):
        print _index_j, '内循环数据：',baseArray[_index_j]
        if(baseArray[index]<baseArray[_index_j]):
            baseArray[index],baseArray[_index_j] = baseArray[_index_j],baseArray[index]
            
print '------排序后的结果-----'
print baseArray


#使用enumerate函数进行迭代
for key,value in enumerate(baseArray):
    print key,value

# 随机函数 choice
print  '随机打印baseArray里面的一个数:',choice(baseArray)


# 字符串
newString = 'hello world!'
newString2 = 'Python Runoob!'
print newString[0],newString2[1:5]
# 字符串修改
print '更新字符串 ： ',newString[:6]+'oh shit!'


# 格式化字符串  这里和C语言是一样的
print "My name is %s and weight is %d kg!" % ('Zara', 21) 


# 列表
lists = ['zara',289,'yoiku']
lists2 = [200,700,90]
lists.extend(lists2)
print lists


# Python的元组与列表类似，不同之处在于元组的元素不能修改。
## 元组中只包含一个元素时，需要在元素后面添加逗号
tup1 = (40)
print tup1

##元组可以使用下标索引来访问元组中的值，如下实例:
tup1 = ('physics', 'chemistry', 1997, 2000);
tup2 = (1, 2, 3, 4, 5, 6, 7 );

print "tup1[0]: ", tup1[0]
print "tup2[1:5]: ", tup2[1:5]

# 元组中的元素值是不允许修改的，但我们可以对元组进行连接组合，如下实例:
tup1 = (12, 34.56);
tup2 = ('abc', 'xyz');

# 以下修改元组元素操作是非法的。
# tup1[0] = 100;

# 创建一个新的元组
tup3 = tup1 + tup2;
print tup3;


# '''
# 字典是另一种可变容器模型，且可存储任意类型对象。
# 字典的每个键值(key=>value)对用冒号(:)分割，每个对之间用逗号(,)分割，整个字典包括在花括号({})中
# 和java中的Map一样,json
# '''

dictionarys = {'Alice': '2341', 'Beth': '9102', 'Cecil': '3258','age':8}
dictionarys['age'] = 18
print "dictionarys['age'] : ",dictionarys['age']
##清除字典中数据
dictionarys.clear()   


# 日期，日历，时间
cal = calendar.month(2017,12)
print '以下是2017年12月份的日历'
print cal






