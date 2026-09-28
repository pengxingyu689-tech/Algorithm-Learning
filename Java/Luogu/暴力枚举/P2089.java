import  java.util.*;
import  java.io.*;

public class P2089 {
    static  int n;
    static int[][] res = new int[60000][10];
    static int count=0;
    static int[] a = new int[10];
    static void dfs(int pos,int sum){
        if(pos==10){
            if(sum==n){
                res[count++]=a.clone();
            }
            return;
        }
        for(int i=1;i<=3;i++){
            
            a[pos]=i;
            dfs(pos+1,sum+i);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = sc.nextInt();
        if(n<10 || n>30){
            out.println(0);
            out.flush();
            return;  
            
        }
        dfs(0,0);
        out.println(count);
        for(int i=0;i<count;i++){
            for(int j =0;j<10;j++){
                out.print(res[i][j]+" ");
            }
            out.println();
        }
        out.flush();


   
    }
}
