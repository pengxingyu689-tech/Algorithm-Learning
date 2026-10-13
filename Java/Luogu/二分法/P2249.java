import java.io.*;
import java.util.*;

public class P2249 {
    static int[] a;
    static int dfs(int l,int r,int num){
        int ans=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]==num){
                ans = mid+1;
                r=mid-1;
            }
            if(a[mid]>num){
                r=mid-1;
            }
            else if(a[mid]<num){
                l=mid+1;
            }
            
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n =sc.nextInt();
        int m =sc.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            out.print(dfs(0,n-1,sc.nextInt())+" ");
        }
        out.flush();
    }
}
