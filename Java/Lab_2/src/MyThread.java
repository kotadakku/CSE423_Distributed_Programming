public class MyThread extends Thread {
    int tid;
    Lock lock;
    public MyThread(int id, Lock lock) {
        tid = id;
        this.lock = lock;
    }
    void CS() {
        System.out.println(tid + " CS");
        System.out.println(tid + " CS");
    }
    void nonCS() {
        System.out.println(tid + " No CS");
        System.out.println(tid + " No Cs");
    }
    
    public void run() {
        while(true) {
            lock.requestCS(tid);
            CS();
            lock.releaseCS(tid);
            nonCS();
        }
    }
    public static void main(String[] args){
        
        int N = 10;
        Lock lock = new Bakery(N);
        MyThread t[]; 
        t = new MyThread[N];    
        for (int i = 0; i < N; i++) {
            t[i] = new MyThread(i, lock);
            t[i].start();
        }
    }
}
   