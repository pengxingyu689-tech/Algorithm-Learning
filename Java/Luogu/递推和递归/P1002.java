import java.util.*;
import java.io.*;

public class P1002 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long[][] dp = new long[25][25];
        long[][] dirt = {{1,2},{2,1},{-1,2},{2,-1},{1,-2},{-2,1},{-1,-2},{-2,-1}};
        boolean[][] blocked = new boolean[25][25];
        int bx = sc.nextInt();
        int by = sc.nextInt();
        int  hx = sc.nextInt();
        int hy = sc.nextInt();
        blocked[hx][hy] = true;
        for(int i=0;i<8;i++){
            
                int  x1 =(int)(hx+dirt[i][0]);
                int  y1 = (int)(hy+dirt[i][1]);
                if(x1>=0 && y1>=0){
                    blocked[x1][y1] = true;
                }
            
        }

        for(int i=1;i<25;i++){
            if(blocked[0][i])
                break;
            dp[0][i] = 1;
        }
        for(int i=1;i<25;i++){
            if(blocked[i][0])
                break;
            dp[i][0] = 1;
        }
        for(int i=1;i<=bx;i++){
            for(int j=1;j<=by;j++){
                if(blocked[i][j]){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        out.print(dp[bx][by]);
        out.flush();
    }
}
