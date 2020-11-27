import threading
import time
import random

class myThread (threading.Thread):
   def __init__(self, name, number, l_num):
        threading.Thread.__init__(self)
        self.name = name
        self.number = number
        self.list = l_num

   def run(self):
        check(self.name, self.number, self.list)

def check(name, n, list):
    for i in list:
        if i%n==0:
            print(name+" find: "+str(i)+"")
    
randomlist = []
for i in range(0,50):
    n = random.randint(1,100)
    randomlist.append(n)

thread1 = myThread("Thread-1",3, randomlist)
thread2 = myThread("Thread-2", 5, randomlist)

thread1.start()
thread1.join()
thread2.start()
# thread2.join()
