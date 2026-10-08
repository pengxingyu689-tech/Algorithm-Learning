import java.util.*;
import java.io.*;

public class P1044{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n= sc.nextInt();
        long[] dp = new long[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=i;j++)
                dp[i] +=dp[j-1]*dp[i-j];
        out.println(dp[n]);
        out.flush();
    }
}