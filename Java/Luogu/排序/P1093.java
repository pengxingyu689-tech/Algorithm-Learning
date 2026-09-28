import  java.util.*;
import  java.io.*;

public class P1093 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n =sc.nextInt();
        int[][] a = new int[n+1][3];
        for(int i=1;i<=n;i++){
            int y =sc.nextInt();
            int s =sc.nextInt();
            int w =sc.nextInt();
            int z=s+y+w;
            a[i][0]=z;
            a[i][1]=y;
            a[i][2]=i;
        }
        Arrays.sort(a,1,n+1,(x,y)->{
            if(x[0]!=y[0]){
                return Integer.compare(y[0],x[0]);
            }
            if(x[1]!=y[1]){
                return Integer.compare(y[1],x[1]);
            }
            return Integer.compare(x[2],y[2]);
        });
        for(int i=1;i<=5;i++){
            out.println(a[i][2]+" "+a[i][0]);
        }
        out.flush();
    }
}
