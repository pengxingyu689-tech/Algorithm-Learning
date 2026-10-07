import java.util.*;
import java.io.*;

public class P2036 {
    static int[][] a;
    static int res=100000000;

    static void dfs(int pos,int suan,int ku){
        if(pos==a.length){
            if(suan==1 && ku==0)
                return;
            res = Math.min(res,Math.abs(suan-ku));
            return;
        }
        dfs(pos+1,suan,ku);
        dfs(pos+1,suan*a[pos][0],ku+a[pos][1]);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n =sc.nextInt();
        a=new int[n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                a[i][j] = sc.nextInt();

        dfs(0,1,0);
        out.println(res);
        out.flush();
    }
}
