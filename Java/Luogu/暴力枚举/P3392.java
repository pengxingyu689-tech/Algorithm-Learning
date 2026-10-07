import java.util.*;
import java.io.*;

public class P3392 {
    static int func(int i,int j,int k,char[][] A){
        int count=0;
        for(int a=0;a<i;a++)
            for(int b=0;b<A[0].length;b++){
                if(A[a][b]!='W'){
                    count++;
                }
            }

        for(int a=i;a<i+j;a++)
            for(int b=0;b<A[0].length;b++){
                if(A[a][b]!='B'){
                    count++;
                }
            }

        for(int a=i+j;a<A.length;a++)
            for(int b=0;b<A[0].length;b++){
                if(A[a][b]!='R'){
                    count++;
                }
            }

        return count;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n =sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] a = new char[n][m];
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<m;j++)
                a[i][j] = line.charAt(j);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=n-2;i++){
            for(int j=1;j<=n-i-1;j++){
                int k = n-i-j;
                res = Math.min(res,func(i,j,k,a));
                
            }
        }
        out.println(res);
        out.flush();
    }
}
