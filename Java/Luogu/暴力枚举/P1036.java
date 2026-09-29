import java.util.*;
import java.io.*;

public class P1036 {
    static int count = 0;
    static int n,k;
    static int[] a ;

    static void initial(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
    }

    static boolean prime(int n){
        if(n<=1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    static void dfs(int pos,int start,int sum){
        if(pos==k){
            if(prime(sum)){
                count++;
                return;
            }
            return ;
        }
        for(int i=start;i<n;i++){
            dfs(pos+1,i+1,sum+a[i]);
        }
    }

    public static void main(String args[]){
        PrintWriter out = new PrintWriter(System.out);
        initial();
        dfs(0,0,0);
        out.print(count);
        out.flush();

    }
}
