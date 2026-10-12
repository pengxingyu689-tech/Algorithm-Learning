import  java.util.*;
import java.io.*;

public class P5019 {
    
    static int[] a;
    static int res = 0;

    static void dfs(int left,int right){
        if(right<left)
            return ;
        if(right==left){
            res+=a[left];
            return;
        }
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int i=left;i<=right;i++){
            if(a[i]<min){
                min=a[i];
                index=i;
            }
        }
        res+=min;
        for(int i=left;i<=right;i++){
            a[i]-=min;
        }
        
        dfs(left,index-1);
        dfs(index+1,right);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        a = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        dfs(1,n);
        out.print(res);
        out.flush();
    }
}
