import java.util.*;
public class ford{
private int num_ver;
private int d[];
public static final int max_val=999;
    public ford(int num_ver)
    {
        this.num_ver=num_ver;
        d=new int[num_ver+1];
    }

    public void bfe(int source,int a[][])
    {
        for(int node=1;node<=num_ver;node++)
        {
            d[node]=max_val;
        }
        d[source]=0;

        for(int node=1;node<=num_ver-1;node++){
            for(int sn=1;sn<=num_ver;sn++)
            {
                for(int dn=1;dn<=num_ver;dn++)
                {
                    if(a[sn][dn]!=max_val)
                    {
                        if(d[dn]>d[sn]+a[sn][dn])
                        d[dn]=d[sn]+a[sn][dn];
                    }
                }
            }
        }
        for(int sn=1;sn<=num_ver;sn++){
            for(int dn=1;dn<num_ver;dn++)
            {
                if(a[sn][dn]!=max_val)
                {
                    if(d[dn]>d[sn]+a[sn][dn])
                    System.out.println("graph contains negative edge cycle");
                }
            }



        }

        for(int vertex=1;vertex<=num_ver;vertex++)
        {
            System.out.println("distance from source"+source+"to"+vertex+"is"+d[vertex]);
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the num of vertices");
        int num_ver=sc.nextInt();
        int a[][]= new int[num_ver+1][num_ver+1];
        System.out.println("enter the adjacency matrix");
        for(int sn=1;sn<=num_ver;sn++)
        {
            for(int dn=1;dn<=num_ver;dn++)
            {
                a[sn][dn]=sc.nextInt();

                if(sn==dn)
                {
                    a[sn][dn]=0;
                    continue;
                }
                if(a[sn][dn]==0)
                {
                    a[sn][dn]=max_val;
                }
            }

        }
        System.out.println("enter the source vertex");
        int source=sc.nextInt();

        ford f = new ford(num_ver);
        f.bfe(source,a);
    }
}