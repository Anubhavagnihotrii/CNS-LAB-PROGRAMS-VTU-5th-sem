import java.util.*;
public class leak{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the bucket");
        int buc_size =sc.nextInt();
        System.out.println("enter the number of packets");
        int n = sc.nextInt();
        int a[]= new int[n];
        System.out.println("enter the size of the each packet");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("enter the output rate");
        int out=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("transmitting packet of size"+a[i]);
            if(a[i]>buc_size)
            {
                System.out.println("overfow");
            }
            else
            {
                if(a[i]<=out)
                {
                    System.out.println("transmitted"+a[i]);
                }
                else if(a[i]>out)
                {
                    while(a[i]>out)
                    {
                        a[i]-=out;
                        System.out.println("transmitted"+out);
                    }
                    System.out.println("transmitted"+a[i]);
                }
            }
        }
    }
}