import java.util.*;
import java.net.*;

public class sender{
    public static void main(String[] args)throws Exception {
        System.out.println("sender");
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the message");
        while(true)
        {
            String message=sc.nextLine();
            InetAddress ip =InetAddress.getByName("127.0.0.1");
            DatagramPacket dp=  new DatagramPacket(message.getBytes(),message.length(),ip,3000);
            ds.send(dp);
        }
        
    }
}