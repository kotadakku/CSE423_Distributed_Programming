import java.net.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class DatagramClient {
    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        String hostname;
        int port = 2018;
        int len = 1024;
        DatagramPacket sPacket, rPacket;
        if (args.length > 0)
            hostname = args[0];
        else
            hostname = "localhost";
        try {
            InetAddress ia = InetAddress.getByName(hostname);
            DatagramSocket datasocket = new DatagramSocket();
            while (true) {
                try {
                	Random r = new Random();	
                	int r_number = r.nextInt(15);
                	String echoline="";
                	for(int i=1; i<=(r_number+1) ;i++) {
                		int item = r.nextInt(500);
                		echoline = echoline+" "+ item;
                	}

                	System.out.println("Chuoi ban dau:"+echoline);
                    byte[] buffer = new byte[echoline.length()];
                    buffer = echoline.getBytes();
                    sPacket = new DatagramPacket(buffer, buffer.length, ia, port);
                    TimeUnit.SECONDS.sleep(2);
                    datasocket.send(sPacket);
                    
                    
                    byte[] rbuffer = new byte[len];
                    rPacket = new DatagramPacket(rbuffer, rbuffer.length);
                    datasocket.receive(rPacket);
                    String chuoinhan = new String(rPacket.getData());
                    System.out.println("Chuoi nhan duoc:"+chuoinhan);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (SocketException se) {
            System.err.println(se);
        }
    } 
}