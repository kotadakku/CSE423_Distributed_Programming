import java.rmi.*;
import java.rmi.server.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
 
public class RMIServer extends UnicastRemoteObject
         implements SapxepInterface {
 
      public RMIServer() throws RemoteException {   }
 
      public int[] SapXep(int[] x) {
    	  for(int i=0; i<x.length-1; i++) {
    		  for(int j=i; j<x.length; j++) {
    			  if(x[j]%2==0) {
        			  int c= x[i];
        			  x[i]=x[j];			  
        			  x[j]=c;
        			  break;
    			  }   
    		  }
 		  
    	  }
		return x;
      }
      
      
      public static void main (String[] argv) {
		   try {
			   System.setSecurityManager(new RMISecurityManager());

			   RMIServer Hello = new RMIServer();			   		   
			   Naming.rebind("ABC", Hello);

			   System.out.println("Addition Server is ready.");
			   }catch (Exception e) {
				   System.out.println("Addition Server failed: " + e);
				}
		   }
 }