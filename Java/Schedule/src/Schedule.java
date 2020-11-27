public class Schedule extends Thread {
    static int x=0;
    static int y=0;
    public Schedule(){
    }
    public static int op1(){
        x=1;
        return y;
    }

    public static int op2(){
        y=2;
        return 3*x;
    }
    public void run() {
        if(getName()=="t1"){
            System.out.println(op1());
        }
        else{
            System.out.println(op2());
        }      
    }
    public static void main(String [] args) {
        Schedule t = new Schedule();
        Schedule t2 = new Schedule();    
        t.setName("t1");
        t2.start();
        t.start();
        t2.setName("t2");
    }
}