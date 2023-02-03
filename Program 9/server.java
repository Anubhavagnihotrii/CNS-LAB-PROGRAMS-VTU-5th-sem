import java.net.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

public class server{
    public static void main(String[] args)throws Exception {

        try{
        ServerSocket server = new ServerSocket(5000,1);
        System.out.println("waiting for client to get connected");
        Socket socket = server.accept();
        System.out.println("client connected successfully");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out= new DataOutputStream(socket.getOutputStream());
        String filename=in.readUTF();
        byte[] filedata=Files.readAllBytes(Paths.get(filename));
        String filecontent = new String(filedata);
        out.writeUTF(filecontent.toString());

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("file doesn't exist");
        }    
    }
}