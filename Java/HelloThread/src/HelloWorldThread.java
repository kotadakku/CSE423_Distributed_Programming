public class HelloWorldThread extends Thread {
    public void run() {
        for(int i =0; i<10; i++){
            System.out.println (getName() + "-- Hello World");
        }
        
    }
    public static void main(String [] args) {
        HelloWorldThread t = new HelloWorldThread () ;
        HelloWorldThread t2 = new HelloWorldThread () ;
        t.start();
        t.setName("Thread 1");
        t2.start();
        t.setName("Thread 2");
    }
}