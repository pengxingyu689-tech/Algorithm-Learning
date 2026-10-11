import java.util.*;
import java.io.*;

public class P2240 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N=sc.nextInt();
        int T=sc.nextInt();
        double[][] a = new double[N][3];
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                a[i][j]=sc.nextDouble();
            }
        }
        for(int i=0;i<N;i++){
            a[i][2]=a[i][1]/a[i][0];
        }
        double res=0;
        Arrays.sort(a,(i,j)->Double.compare(j[2],i[2]));
        for(int i=0;i<N;i++){
            if(a[i][0]<=T){
                res+=a[i][1];
                T-=a[i][0];
            }
            else{
                res+=T*a[i][2];
                break;
            }
        }
        out.printf("%.2f",res);
        out.flush();
        
    }
}
