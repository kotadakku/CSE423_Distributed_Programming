import java.net.*;
import java.io.*;
public class DatagramServer {
	public static String sapxep(String s) {
		String[] words = s.split("\\s");
		String a="";
		for(String w: words) {
			if(Integer.parseInt(w)%2==0) {
				a=a+" "+w;
			}	
		}
		for(String w: words) {
			if(Integer.parseInt(w)%2!=0) {
				a=a+" "+w;
			}	
		}
		return a;
	}
	
    public static void main(String[] args) {
        DatagramPacket datapacket, returnpacket;
        int port = 2018;
        int len = 1024;
        try {
            DatagramSocket datasocket = new DatagramSocket(port);
            byte[] buf = new byte[len];
            datapacket = new DatagramPacket(buf, buf.length);
            while (true) {
                try {
                	
                    byte[] rbuffer = new byte[len];
                    datapacket = new DatagramPacket(rbuffer, rbuffer.length);
                    datasocket.receive(datapacket);
                    String chuoinhan = new String(datapacket.getData());
                    
                    
                    String chuoisapxep = sapxep(chuoinhan.trim());
                    byte[] buffer = new byte[chuoisapxep.length()];
                    buffer = chuoisapxep.getBytes();
                    
                    returnpacket = new DatagramPacket(
                            buffer,
                            buffer.length,
                            datapacket.getAddress(),
                            datapacket.getPort()); datasocket.send(returnpacket);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (SocketException se) {
            System.err.println(se);
        }
    }
}
