import java.util.Random;
class Producer implements Runnable {
    BoundedBufferMonitor b = null;
    public Producer(BoundedBufferMonitor initb) {
        b = initb;
        new Thread(this).start();
    }
    public void run() {
        int item;
        Random r = new Random();
        while (true) {
            item = r.nextInt();
            System.out.println("produced item " + item);
            b.deposit(item);
            Util.mySleep(200);
        }
    }
}
class Consumer implements Runnable {
    BoundedBufferMonitor b = null;
    public Consumer(BoundedBufferMonitor initb) {
        b = initb;
        new Thread(this).start();
    }
    public void run() {
        int item;
        while (true) {
            item = b.fetch();
            System.out.println("fetched item " + item);
             Util.mySleep(50);
        }
    }
}
class ProducerConsumer {
    public static void main(String[] args) {
        BoundedBufferMonitor buffer = new BoundedBufferMonitor();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
    }
}
