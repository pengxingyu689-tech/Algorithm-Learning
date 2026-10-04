import java.util.*;
import  java.io.*;

public class P3799 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] cnt  = new int[5010];
        long count=0;
        long count1=0;
        long count2=0;
        for(int i=0;i<n;i++){
            cnt[sc.nextInt()]++;
        }
        for(int i=0;i<5010;i++){
            if(cnt[i]>=2){
                int x = cnt[i];
                for(int j=0;j<i;j++){
                    if(cnt[j]>0 && cnt[i-j]>0){
                        int y =cnt[j];
                        int z =cnt[i-j];
                        if(j==i-j){
                            count1+=(long)x*(x-1)*y*(y-1)/4;
                        }
                        else count2+=(long)x*(x-1)*y*z/2;
                    }
                }
            }
        }
        count = count1+count2/2;
        out.println(count%(1000000007));
        out.flush();
    }
}
