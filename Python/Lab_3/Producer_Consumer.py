from threading import Thread, Semaphore
import time
import random
import math

queue = []
MAX_NUM = 10

sem = Semaphore()


class ProducerThread(Thread):
    def run(self):
        global queue

        while True:
            sem.acquire()  # wait operation to stop consuming
            if len(queue) == MAX_NUM:
                # print("List is full, producer will wait\n")
                sem.release()  # signal operation only when when queue is full and allow consumer to consume data
                # print("Space in queue, Consumer notified the producer\n")
            else:
                num = random.randint(1,100)
                queue.append(num)  # added any random number from 0 to 4 to the list
                print("Produced", num)
                sem.release()  # signal operation to allow consumer to consume data
                time.sleep(3)  # to allow program to run a bit slower

def check_SNT(item):
        if item<2:
            return False
        for i in range(2,int(math.sqrt(item))+1):
            if item%i==0:
                return False
        return True

class ConsumerThread(Thread):
    def run(self):
        global queue

        while True:
            sem.acquire()  # wait operation to stop producing
            if not queue:
                # print("List is empty, consumer waiting\n")
                sem.release()  # signal operation only when when queue is empty and allow producer to produce data
                # print("Producer added something to queue and notified the consumer \n")
            else:
                num = queue.pop(0)
                if check_SNT(num):
                    print("{} : {}".format(num, "YES"))
                else:
                    print("{} : {}".format(num, "NO"))
                print("Consumed", num)
                sem.release()  # signal operation to allow producer to produce
                time.sleep(3)


def main():
    ProducerThread().start()  # start producer thread
    ConsumerThread().start()  # start consumer thread


if __name__ == '__main__':
    main()
