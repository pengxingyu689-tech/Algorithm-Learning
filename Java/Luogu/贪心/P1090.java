import java.util.*;
import java.io.*;

public class P1090 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++)
            pq.add(sc.nextInt());
        int res =0;
        while(!pq.isEmpty()){
            int a =pq.poll();
            int b =pq.poll();
            res+=(a+b);
            if(pq.isEmpty())
                break;
            pq.add(a+b);

        }
        out.println(res);
        out.flush();
    }
    
}
