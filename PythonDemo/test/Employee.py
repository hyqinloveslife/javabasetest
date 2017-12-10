#coding:utf-8
'''
Created on 2017年12月8日

@author: Administrator
'''
class Employee:
    '所有员工的基类'
    empCount = 0
            
    
    def __init__(self,name,salary):
        self.name = name
        self.salary = salary
        Employee.empCount+=1

    def displayCount(self):
        print "Total Employee %d" % Employee.empCount
        
    def displayEmployee(self):
        print "Name : ", self.name,  ", Salary: ", self.salary
        
    
emp1 = Employee("zara",2000)
emp2 = Employee("Manni",4000)
emp1.displayEmployee()
emp2.displayEmployee()
print "Total employee %d" % Employee.empCount
emp1.displayCount()

emp1.age = 7
emp2.age = 19

emp1.displayEmployee()

