import  java.util.*;
import  java.io.*;

public class P1028 {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i/2;j++){
                dp[i]+=dp[j];
            }
        }
        out.println(dp[n]);
        out.flush();
    }
}
