import java.util.*;
import java.io.*;

public class P1067{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out =  new PrintWriter(System.out);
        int n=sc.nextInt();
        int[] a= new int[n+1];
        for(int i=n;i>=0;i--){
            a[i]=sc.nextInt();
        }
        String res ="";
        for(int i=n;i>=0;i--){
            if(i==0){
                if(a[i]>0)
                    res=res+"+"+a[i];
                else if(a[i]<0)
                    res+=a[i];

                continue;
            }
            String add="";
            if(a[i]>0){
                if(a[i]==1){
                    add+="+";
                }
                else
                    add=add+"+"+a[i];
            }
            else if(a[i]<0){
                if(a[i]==-1){
                    add+="-";
                }
                else
                    add+=+a[i];
            }
            else 
                continue;

            if(i==1){
                add+="x";
            }
            else{
                add+="x^"+i;
            }
            res+=add;
            
        }

        if(res.charAt(0)=='+')            
            out.print(res.substring(1));        
        else            
            out.print(res);
        out.flush();
    }
}