import java.util.*;
import java.io.*;

public class P2392 {
    static int res =0;
    static int min ;
    static void dfs(int pos,int left,int right,int[] a){
        if(pos == a.length){
            int result = Math.max(left,right);
            min = Math.min(min,result);
            return;
        }

        dfs(pos+1,left+a[pos],right,a);
        dfs(pos+1,left,right+a[pos],a);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a,b,c,d;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        int[] A =new int[a];
        for(int i=0;i<a;i++)
            A[i] = sc.nextInt();
        int[] B =new int[b];
        for(int i=0;i<b;i++)
            B[i] = sc.nextInt();
        int[] C =new int[c];
        for(int i=0;i<c;i++)
            C[i] = sc.nextInt();
        int[] D =new int[d];
        for(int i=0;i<d;i++)
            D[i] = sc.nextInt();
        min = 100000000;
        dfs(0,0,0,A);
        res+=min;
        min = 100000000;
        dfs(0,0,0,B);
        res+=min;
        min = 100000000;
        dfs(0,0,0,C);
        res+=min;
        min = 100000000;
        dfs(0,0,0,D);
        res+=min;

        out.println(res);
        out.flush();
    }
}
