import  java.util.*;
import  java.io.*;

public class P1068 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n =sc.nextInt();
        int m=sc.nextInt();
        int[][] a =new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        Arrays.sort(a,(x,y)->{
            if(x[1]!=y[1])
                return Integer.compare(y[1], x[1]);
            return Integer.compare(x[0],y[0]);
        });
        int res = (int)(m*1.5);
        int x = a[res-1][1];
        while(true){
            if(a[res][1]==x){
                res++;
            }
            else{
                break;
            }
        }
        out.println(x+" "+res);
        for(int i=0;i<res;i++){
            out.println(a[i][0]+" "+a[i][1]);
        }
        out.flush();
    }
}
