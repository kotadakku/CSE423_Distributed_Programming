
class BoundedBufferMonitor {
    final int sizeBuf = 10;
    int[] buffer = new int[sizeBuf];
    int inBuf = 0, outBuf = 0, count = 0;
    public synchronized void deposit(int value) {
        while (count == sizeBuf) // buffer full
        {
            System.out.println("Waiting!!!");
            System.out.flush();
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        buffer[inBuf] = value;
        inBuf = (inBuf + 1) % sizeBuf;
        count++;
        if (count == 1) // items available for fetch
            notify();
    }
    public synchronized int fetch() {
        int value;
        while (count == 0) // buffer empty
        {
            System.out.println("Waiting!!!");
            System.out.flush();
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        value = buffer[outBuf];
        outBuf = (outBuf + 1) % sizeBuf;
        count--;
        if (count == sizeBuf - 1) // empty slots available
            notify();
        return value;
    }
}

