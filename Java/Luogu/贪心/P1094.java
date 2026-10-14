import java.util.*;
import java.io.*;

public class P1094{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int l=0,r=n-1;
        int ans=0;
        while(l<=r){
            if(w-a[r]>=a[l]){
                l++;
                r--;
                ans++;
            }
            else{
                r--;
                ans++;
            }
        }
        out.print(ans);
        out.flush();
    }
}