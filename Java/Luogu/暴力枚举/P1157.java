import  java.util.*;
import java.io.*;

public class P1157 {
    static int n,r;
    static int[] a;
    static int count = 0;
    static int[] num;
    static PrintWriter out = new PrintWriter(System.out);

    static void initial(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        num = new int[n];
        for(int i=1;i<=n;i++){
            num[i-1]=i;
        }
        a = new int[r];
        
    }

    static void dfs(int pos,int start){
        if(pos == r){
            for(int i=0;i<r;i++){
                out.printf("%3d",a[i]);
            }
            out.println();
            return ;
        }
        for(int i=start;i<n;i++){
            a[pos] = num[i];
            dfs(pos+1,i+1);
        }
    }
    public static void main(String args[]){
        
        initial();
        dfs(0,0);
        out.flush();
                                                                                        

    }
}
