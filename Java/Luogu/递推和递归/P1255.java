import java.util.*;
import java.io.*;
import  java.math.BigInteger;

public class P1255 {
    static BigInteger[] memo= new BigInteger[5010];
    static BigInteger dfs(int n){
        if(n ==1 || n==2){
            return BigInteger.valueOf(n);
        }
        if(memo[n]!=null){
            return memo[n];
        }
        memo[n] = dfs(n-1).add(dfs(n-2));
        return memo[n];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        out.println(dfs(sc.nextInt()));
        out.flush();
    }
}
