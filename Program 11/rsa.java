import java.util.*;
import java.math.*;
public class rsa{
    public void keygen()
    {
        Scanner sc = new Scanner(System.in);
        Random r1 = new Random(System.currentTimeMillis());
        Random r2 = new Random(System.currentTimeMillis()*10);
        System.out.println("enter the init val for pubkey");
        int pubkey=sc.nextInt();
        BigInteger p = BigInteger.probablePrime(32, r1);
        BigInteger q = BigInteger.probablePrime(32, r2);
        BigInteger n=p.multiply(q);
        BigInteger p_1=p.subtract(new BigInteger("1"));
        BigInteger q_1=q.subtract(new BigInteger("1"));
        BigInteger fi =p_1.multiply(q_1);
        while(true)
        {
            BigInteger GCD = fi.gcd(new BigInteger(pubkey+""));
            if(GCD.equals(BigInteger.ONE))
            {
                break;
            }
            pubkey++;
        }
        BigInteger new_pubkey=new BigInteger(pubkey+"");
        BigInteger new_Prvkey= new_pubkey.modInverse(fi);
        System.out.println("public key"+new_pubkey+","+n);
        System.out.println("private key"+new_Prvkey+","+n);
    }
    public void encdec()
    {
Scanner sc = new Scanner(System.in);

System.out.println("enter  the public key");
String pubkey1=sc.nextLine();
BigInteger pubkey = new BigInteger(pubkey1);


System.out.println("enter  the private key");
String prvkey1=sc.nextLine();
BigInteger prvkey = new BigInteger(prvkey1);


System.out.println("enter n");
String n1=sc.nextLine();
BigInteger n = new BigInteger(n1);

System.out.println("enter  the msg");
String msg1=sc.nextLine();
BigInteger msg = new BigInteger(msg1);

BigInteger ciphertext = msg.modPow(pubkey,n);
BigInteger plainval=ciphertext.modPow(prvkey,n);
System.out.println("cipher text is"+ciphertext);
System.out.println("plain text is "+plainval);
    }
    public static void main(String[] args) {
        
    rsa r = new rsa();
    System.out.println("keygen phase");
    r.keygen();
    System.out.println("enc dec phase");
    r.encdec();
    }
}