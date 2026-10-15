import java.util.*;
import java.io.*;

public class P4447 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            PriorityQueue<Integer> pre = map.get(a[i]-1);
            PriorityQueue<Integer> cur = map.get(a[i]);
            int len =1;
            if(  pre!=null &&!pre.isEmpty()){
                len = pre.poll()+1;
            }
            if(cur == null){
                cur = new PriorityQueue<>();
                map.put(a[i],cur);
            }
            cur.add(len);
        }
        int res =Integer.MAX_VALUE;
        for(PriorityQueue<Integer> i: map.values()){
            if(i!=null && !i.isEmpty()){
                res = Math.min(res,i.poll());
            }
            
        }
        out.println(res);
        out.flush();
    }
}
