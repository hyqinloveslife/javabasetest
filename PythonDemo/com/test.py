# -*- coding: UTF-8 -*-
'''
Created on 2017年12月7日

@author: 黄叶钦
'''

##循环   将奇数和偶数分开   感觉Python语言好傻，语法太不符合规范了
numbers_ = [12,37,8,65,25]
even =[]
odd = []
while len(numbers_)>0:
    element__ = numbers_.pop()
    if(element__%2==0):
        even.append(element__)
    else:
        odd.append(element__)
        
print even
print odd           