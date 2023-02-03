import java.util.*;
import java.net.*;
public class recv {
    public static void main(String[] args)throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);
        System.out.println("receiver");
        byte[]buf= new byte[1024];
        while(true){
            DatagramPacket dp = new DatagramPacket(buf,1024);
            ds.receive(dp);
            String message = new String(dp.getData(),0,dp.getLength());
            System.out.println(message);
        }
    }
}
