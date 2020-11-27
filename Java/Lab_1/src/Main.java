import java.util.Random;
import java.util.Scanner;

public class Main extends Thread {
	int[] a;
	
	public Main(int [] a){
        this.a= a;
    }
	
	public void run(){
		if(getName() == "t1") {
			for(int i=0; i<a.length; i++)
		        
	            if(a[i]%3==0){
	                System.out.println(getName()+":"+a[i]); 
	        }
		}
		if(getName() == "t2") {
			for(int i=0; i<a.length; i++)
		        
	            if(a[i]%5==0){
	                System.out.println(getName()+":"+a[i]); 
	        }
		}
    }
	
	public static void main(String [] args) { 
		System.out.print("Nhap n: ");
		int x;
        try (Scanner sc = new Scanner(System.in)) {
			x = sc.nextInt();
		}
        
        int[] b = new int[x];
        Random rd = new Random();
		for(int i=0; i< x; i++){
            b[i] = rd.nextInt(100);
        }
        
        Main t1 = new Main(b);
        Main t2 = new Main(b);
         
        t1.setName("t1");
        t2.setName("t2");
	    t2.start();  
	     try {
	        	t2.join();
//	            t2.join();
	            } catch ( InterruptedException e){};
        t1.start();   
	}
}
