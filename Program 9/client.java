import java.util.*;
import java.net.*;
import java.nio.*;
import java.io.*;
public class client {
    public static void main(String[] args)throws Exception {
        Socket socket=new Socket("127.0.0.1",5000);
        System.out.println("client connected successfully");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the filename");
        String filename=sc.nextLine();

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out= new DataOutputStream(socket.getOutputStream());

        out.writeUTF(filename);
        String filecontent=in.readUTF();
        if(filecontent.length()>0)
        {
            System.out.println(filecontent);
        }
        else{
            System.out.println("empty");
        }
    }
}
