import java.util.*;
import java.io.*;

public class P1563{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLine();
        }
        int[][] b = new int[m][2];
        for(int i=0;i<m;i++){


            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        int pos =0;
        for(int i=0;i<m;i++){
            int x=1;
            if(b[i][0]==0){
                x*=-1;
            }
            else{
                x*=1;
            }
            if(arr[pos].charAt(0)=='0'){
                x*=1;
            }
            else{
                x*=-1;
            }
            int y = b[i][1];
            if(x==1){
                pos=(pos+y)%n;
            }
            else{
                if(pos>=y)
                    pos = pos-y;
                else
                    pos=n-Math.abs(pos-y)%n;
            }
        }

        out.print(arr[pos].substring(2));
        out.flush();
    }
}
