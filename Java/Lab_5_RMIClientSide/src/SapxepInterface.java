   import java.rmi.*;
 
   public interface SapxepInterface extends Remote {
	   public int[] SapXep(int[] x) throws RemoteException;
   }