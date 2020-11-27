
class BoundedBuffer {
    final int size = 10;
    int[] buffer = new int[size];
    int inBuf = 0, outBuf = 0;
    BinarySemaphore mutex = new BinarySemaphore(true);
    CountingSemaphore isEmpty = new CountingSemaphore(0);
    CountingSemaphore isFull = new CountingSemaphore(size);

    public void deposit(int value) {
        isFull.P();// wait if buffer is full
        mutex.P(); // ensures mutual exclusion
        buffer[inBuf] = value; // update the buffer
        inBuf = (inBuf + 1) % size;
        mutex.V();
        isEmpty.V();  // notify any waiting consumer
    }
    public int fetch() {
        int value;
        isEmpty.P(); // wait if buffer is empty
        mutex.P();  // ensures mutual exclusion
        value = buffer[outBuf]; //read from buffer
        outBuf = (outBuf + 1) % size;
        mutex.V();
        isFull.V(); // notify any waiting producer
        return value;
    }
}