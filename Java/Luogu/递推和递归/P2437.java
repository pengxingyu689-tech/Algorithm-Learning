import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class P2437 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int m=sc.nextInt();
        int n = sc.nextInt();
        int x = n-m+1;
        BigInteger[] dp = new BigInteger[x+1];
        dp[1]=BigInteger.valueOf(1);
        dp[2]=BigInteger.valueOf(1);
        for(int i=3;i<=x;i++){
            dp[i]=dp[i-1].add(dp[i-2]);
        }
        out.println(dp[x]);
        out.flush();
    }
}
