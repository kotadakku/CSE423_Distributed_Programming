import threading

class myThread(threading.Thread):
    def run(self):
        for i in range(10):
            print(threading.currentThread().getName() + "-- Hello World")

def main():
    thread1 = myThread()
    thread2 = myThread()

    thread1.start()
    thread2.start()

if __name__ == '__main__':
    main()