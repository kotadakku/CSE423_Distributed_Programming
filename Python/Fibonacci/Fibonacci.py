from threading import Thread
class Fibonacci(Thread):
    def __init__(self, n):
        Thread.__init__(self)
        self.n = n
        self._result = 0

    def run(self):
        if self.n == 1 or self.n == 2:
            self.result = 1
        else:
            f1 = Fibonacci(self.n - 1)
            f2 = Fibonacci(self.n - 2)
            f1.start()
            f2.start()
            f1.join()
            f2.join()
            self.result = f1.result + f2.result

    @property
    def result(self):
        return self._result

    @result.setter
    def result(self, value):
        self._result = value


def main():
    f = Fibonacci(10)
    f.start()
    f.join()
    print(f.result)

if __name__ == '__main__':
    main()

