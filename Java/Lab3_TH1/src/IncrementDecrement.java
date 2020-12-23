
import java.util.Random;
class Producer implements Runnable {
    BoundedBuffer b = null;
    public Producer(BoundedBuffer initb) {
        b = initb;
        new Thread(this).start();
    }
    public void run() {
        
        Random r = new Random();
        
        while (true) {
        	int item = r.nextInt(5000);
            System.out.println("T1 -- : " + b.increment());
            try {
                Thread.sleep(item);
            } catch (InterruptedException e) {
            }
        }
    }
}
class Consumer implements Runnable {
    BoundedBuffer b = null;
    public Consumer(BoundedBuffer initb) {
        b = initb;
        new Thread(this).start();
    }
    
    public void run() {
    	Random r = new Random();
        
        while (true) {
        	int item = r.nextInt(5000);
            System.out.println("T2 ++ : " + b.decrement());
            try {
            Thread.sleep(item);
        } catch (InterruptedException e) {
        }
        }
    }
}
class IncrementDecrement {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
    }
}
