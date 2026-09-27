import java.util.*;
import java.io.*;

public class P1065 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        int [] q = new int[n*m];
        int[] now = new int[n];
        int[] end = new int[n];
        int[][] use = new int[m][10000];
        for(int i=0;i<n*m;i++){
            q[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n*m;i++){
            int x = q[i]-1;
            int Now = now[x];
            now[x]++;
            int machine = a[x][Now]-1;
            int time = b[x][Now];
            int start = end[x]+1;
            while(true){
                boolean ok =true;
                for(int j=0;j<time;j++){
                    if(use[machine][start+j]==1){
                        ok=false;
                    }
                }
                if(ok){
                    break;
                }
                start++;
            }


            for(int j=0;j<time;j++){
                use[machine][start+j]=1;
            }
            end[x]=start+time-1;
        }

        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(end[i],max);
        }
        out.print(max);
        out.flush();
    }
}
