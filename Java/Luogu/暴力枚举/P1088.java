import  java.util.*;
import  java.io.*;

public class P1088 {
    static int n;
    static int[] res,num;
    static boolean[] used;
    static int count = 0;
    static int m;
    static boolean find = false;
    static PrintWriter out = new PrintWriter(System.out);

    static void initial(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        res = new int[n];
        used = new boolean[n];
    }

    static void dfs(int pos){
        if(find)
            return;
        if(pos==n){
            
            if(count++==m){
                for(int i=0;i<n;i++){
                    out.print(res[i]+" ");
                }
                find = true;
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!used[i]){
                used[i]=true;
                res[pos]=num[i];
                dfs(pos+1);
                used[i]=false;
            }
        }
    }

    public  static void main(String args[]){
        initial();
        dfs(0);
        out.flush();
    }
}
