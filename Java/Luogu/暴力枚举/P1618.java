import java.util.*;
import java.io.*;

public class P1618{
    static int[][] res = new int[50000][9];
    static int count=0;
    static int A,B,C;
    static int [] a=new int[9];
    static boolean[] used = new boolean[10];
    static boolean check(int[] a){
        int i = 100*a[0]+10*a[1]+a[2];
        int j = 100*a[3]+10*a[4]+a[5];
        int k = 100*a[6]+10*a[7]+a[8];
        if(i*B==j*A && j*C==k*B){
            return true;
        }
        return false;
    }
    static void dfs(int pos){
        if(pos==9){
            if(check(a)){
                res[count++] = a.clone();
                return ;
            }
            return ;
        }
        for(int i=1;i<=9;i++){
            if(!used[i]){
                used[i]=true;
                a[pos]=i;
                dfs(pos+1);
                used[i]=false;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        dfs(0);
        if(count==0){
            out.println("No!!!");
            out.flush();
            return ;
        }
        else
            for(int i=0;i<count;i++){
                for(int j=0;j<9;j++){
                    out.print(res[i][j]);
                    if(j%3==2){
                        out.print(" ");
                    }
                    
                }
                out.println();
            }
        out.flush();
        
    }
}