import java.util.*;
import java.io.*;

public class P1149 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int count =0;
        int[] num ={6,2,5,5,4,5,6,3,7,6};
        int[] a = new int[2000];
        a[0]=num[0];

        for(int i=1;i<2000;i++){
            for(int j=i;j>0;j/=10)
                a[i]+=num[j%10];
        }

        for(int i=0;i<1000;i++)
            for(int j=0;j<1000;j++){
                if(a[i]+a[j]+a[i+j]+4==n)
                    count++;
            }
                
                
        
        out.println(count);
        out.flush();
    }
}
