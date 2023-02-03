import java.security.MessageDigest;
import java.util.*;
public class crc{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the message");
        String message = sc.nextLine();
        System.out.println("enter the generator");
        String generator = sc.nextLine();

        int data[]= new int[message.length()+generator.length()-1];
        int divisor[]= new int[generator.length()];

        for(int i=0;i<message.length();i++)
        {
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
        for(int i=0;i<generator.length();i++)
        {
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        }
        
        for(int i=0;i<message.length();i++)
        {
            if(data[i]==1)
            {
                for(int j=0;j<divisor.length;j++)
                data[i+j]^=divisor[j];
            }
        }
        System.out.println("checksum generated is");
        for(int i=0;i<message.length();i++)
        {
        data[i]=Integer.parseInt(message.charAt(i)+"");
            
        }
        for(int i=0;i<data.length;i++)
        System.out.print(data[i]);


        System.out.println();




        System.out.println("enter the checksum generated");
         message = sc.nextLine();
       data= new int[message.length()+generator.length()-1];
     divisor= new int[generator.length()];

        for(int i=0;i<message.length();i++)
        {
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
        for(int i=0;i<generator.length();i++)
        {
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        }
        
        for(int i=0;i<message.length();i++)
        {
            if(data[i]==1)
            {
                for(int j=0;j<divisor.length;j++)
                data[i+j]^=divisor[j];
            }
        }


        Boolean b = true;
        for(int i=0;i<data.length;i++)
        {
            if(data[i]==1)
            {
                b=false;
                break;
            }

        }

        if(b==true)
        {
            System.out.println("valid");
        }
        else{
            System.out.println("not valid");
        }
    }
}