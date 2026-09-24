import java.util.*;
import java.io.*;

public class P4924 {
    static int[][] a ;
    static int[][] temp;
    static Scanner sc = new Scanner(System.in);
    static int n,m;

    static void initial(){
        int count =1;
        n =sc.nextInt();
        a= new int[n+1][n+1];
        temp =  new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
            a[i][j] = temp[i][j] =count;
            count++;
            }
        }
    }


    static void turn(int x,int y,int r,int z){
        for(int i=x-r;i<=r+x;i++){
            for(int j=y-r;j<=y+r;j++){
                if(z==0)
                    a[x+j-y][x+y-i] = temp[i][j];
                else
                    a[x+y-j][y-x+i] = temp[i][j];
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
            temp[i][j] = a[i][j];
            }
        }

    }
    

    public static void main(String args[]){
        PrintWriter out = new PrintWriter(System.out);
        initial();
        m = sc.nextInt();
        
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int r=sc.nextInt();
            int z=sc.nextInt();

            turn(x,y,r,z);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                out.print(a[i][j]+" ");
            }
            out.println();
        }
        out.flush();
    
    }
    
    
}
