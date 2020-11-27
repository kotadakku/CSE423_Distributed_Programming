
import java.util.Random;
class Producer implements Runnable {
    BoundedBuffer b = null;
    public Producer(BoundedBuffer initb) {
        b = initb;
        new Thread(this).start();
    }
    public void run() {
        int item;
        Random r = new Random();
        while (true) {
            item = r.nextInt(500);
            System.out.println("Produced item " + item);
            b.deposit(item);
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
    public boolean check_SNT(int item){
        if(item<2) return false;
        for(int i=2; i<=Math.sqrt(item); i++)
            {
                if(item%i==0){
                    return false;
                }
            }
        return true;
    }
    public void run() {
        int item;
        while (true) {
            item = b.fetch();
            System.out.println("Fetched item " + item);
            if(check_SNT(item)){
                System.out.println(item+" :YES ");
            }
            else{
                System.out.println(item+" :NO ");
            }
            
            
            try {
            Thread.sleep(item);
        } catch (InterruptedException e) {
        }
        }
    }
}
class ProducerConsumer {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
    }
}
