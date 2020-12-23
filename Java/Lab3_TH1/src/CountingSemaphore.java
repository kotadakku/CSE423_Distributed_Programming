
public class CountingSemaphore {
    int value;
    public CountingSemaphore(int initValue) {
        value = initValue;
    }
    public synchronized void P() {
        value--;
        if (value < 0) {
            System.out.println("Waiting!!!");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    public synchronized void V() {
        value++;
        if (value <= 0) notify();
    }
}
