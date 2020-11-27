
import java.rmi.*;
import java.util.Random;
import java.util.Scanner;
 
public class RMIClient {
	public static void main (String[] args) {
		SapxepInterface sapxep;
		try {
  		    System.setSecurityManager(new RMISecurityManager());
  		    sapxep = (SapxepInterface)Naming.lookup("rmi://localhost/ABC");
			
			System.out.print("Nhap so phan tu mang: ");
			Scanner sc = new Scanner(System.in);
			int n= sc.nextInt();
			
			int x[] = new int[n];
			Random rd = new Random();
			
			for(int i=0; i<x.length; i++)
				x[i] = rd.nextInt(100);
			
			System.out.println("Mang ban dau :");
			for(int i=0; i<x.length; i++)
				System.out.print(x[i]+"  ");
			
			
			int[] mangsx = sapxep.SapXep(x);
			System.out.println();
			System.out.println("Mang sau khi sap xep :");
			for(int i=0; i<mangsx.length; i++)
				System.out.print(mangsx[i]+ "  ");
			
 
			}catch (Exception e) {
				System.out.println("HelloClient exception: " + e);
				}
		}
}
