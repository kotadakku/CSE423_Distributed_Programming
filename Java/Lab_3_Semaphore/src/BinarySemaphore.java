public class BinarySemaphore {
    boolean value;
    BinarySemaphore(boolean initValue) {
        value = initValue;
    }
    public synchronized void P() {
        while (value == false){
            System.out.println("Waiting!!!");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        value = false;
    }
    public synchronized void V() {
        value = true;
        notify();
    }
}
