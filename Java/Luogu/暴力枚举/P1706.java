import java.util.*;
import java.io.*;

public class P1706 {
    static int n;
    static int[] num,a;
    static PrintWriter out = new PrintWriter(System.out);
    static boolean[] used;
    static void initial(){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=i+1;
        }
        a=new int[n];
        used = new boolean[n];
    }

    static void dfs(int pos){
        if(pos == n){
            for(int i=0;i<n;i++){
                out.printf("%5d",a[i]);
            }
            out.println();
            return ;
        }

        for(int i=0; i<n;i++){
            if(!used[i]){
                a[pos]=num[i];
                used[i]=true;
                dfs(pos+1);
                used[i]=false;
            }
        }
    }
    
    public static void main(String args[]){
        initial();
        dfs(0);

        out.flush();
    }
}
