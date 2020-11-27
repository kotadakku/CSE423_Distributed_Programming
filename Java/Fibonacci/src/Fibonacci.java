public class Fibonacci extends Thread {
    int n;
    int result;
    public Fibonacci(int n) {
        this.n = n;
    }

    public void run() {
        if ((n == 0)||(n == 1 )) result = 1;
        else {
            Fibonacci fl = new Fibonacci(n-1);
            Fibonacci f2 = new Fibonacci(n-2);
            fl.start ();
            f2.start ();
            try {
                fl.join ();
                f2.join ();
            } catch ( InterruptedException e){};
            result = fl.getResult () + f2.getResult ();
        }
    }
    public int getResult (){
        return result ;
    }
    public static void main(String [] args) {
        Fibonacci fl = new Fibonacci(10);
        fl.start ();
        try {
            fl.join ();
        } catch ( InterruptedException e){};
        System.out.println("Answer is " + fl.getResult()); 
    }
}