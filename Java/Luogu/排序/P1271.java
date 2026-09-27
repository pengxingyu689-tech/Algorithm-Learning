import java.util.*;
import java.io.*;


public class P1271 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n =sc.nextInt();
        int m =sc.nextInt();
        int[] cnt = new int[1010];
        for(int i=0;i<m;i++){
            cnt[sc.nextInt()]++;
        }
        for(int i=0;i<1010;i++){
            while(cnt[i]!=0){
                out.print(i+" ");
                cnt[i]--;
            }
        }
        out.flush();
        
    }
}
