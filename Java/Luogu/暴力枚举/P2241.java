import java.util.*;
import java.io.*;

public class P2241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long z=0;
        long c=0;
        long count=0;
        for(long i=1;i<=Math.min(n,m);i++){
            z+=(n-i+1)*(m-i+1);
        }
        long ct=((n+1)*n/2)*(m+1)*m/2;
        c=ct-z;
        out.print(z+" "+c);
        out.flush();
    }
}
