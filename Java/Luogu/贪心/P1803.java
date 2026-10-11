import java.util.*;
import java.io.*;

public class P1803 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++)
                a[i][j] = sc.nextInt();
        }
        Arrays.sort(a,(i,j)->(i[1]-j[1]));
        int res=0;
        long time =0;
        for(int i=0;i<n;i++){
            if(time<=a[i][0]){
                time=a[i][1];
                res++;
            }
        }
        out.println(res);
        out.flush();

    }
}
