from Tkinter import *
import send_sms

class ButtonHandler:

    def __init__(self):      
        self.root = Tk()
        self.root.geometry('1200x1000+200+200')

        self.mousedown = False
        self.label = Label(self.root, text=str(self.mousedown))
        self.can = Canvas(self.root, width='1000', height='800', bg='white')

        self.can.bind("<Button-1>",lambda x:self.handler(x,'press'))
        self.label.pack()
        self.can.pack()
        self.root.mainloop()

    def handler(self,event,button_event):
        print('Handler %s' % button_event) 
        if button_event == 'press':
            send_sms.sendText()

button_event = ButtonHandler()
