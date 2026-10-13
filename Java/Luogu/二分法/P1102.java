import java.util.*;
import java.io.*;

public class P1102{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] a =new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        long ans=0;
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            int x=a[i];
            int l=0;
            int r=n-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(a[mid]==x+c){
                    r=mid-1;
                }
                else if(a[mid]>x+c){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            int left=l;
            l=0;
            r=n-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(a[mid]==x+c){
                    l=mid+1;
                }
                else if(a[mid]>x+c){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            int right =r;
            ans+=right-left+1;
        }
        out.print(ans);
        out.flush();

    }
}