#coding=utf-8
from Tkinter import Frame, Label, Button
import Tkinter
import tkMessageBox

class Application(Frame):

    
    def createWidgets(self):
        self.helloLabel = Label(self, text='Hello, world!')
        self.helloLabel.pack()
        self.quitButton = Button(self, text='hello', command=self.sayHello)
        self.quitButton.pack()
    
    
    def __init__(self,master=None):
        print 'init'
        Frame.__init__(self, master)
        self.pack()
        self.createWidgets()
    
    def sayHello(self):
        name = self.nameInput.get() or 'world'
        tkMessageBox.showinfo('Message','hello,%s'%name)
        
app = Application()
app.master.title('hello world')
app.mainloop()    
        
        
        