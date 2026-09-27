import  java.util.*;
import  java.io.*;

public class P1059 {
    public  static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n=sc.nextInt();
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0;i<n;i++){
            hash.add(sc.nextInt());
        }
        List<Integer> a = new ArrayList<>(hash);
        Collections.sort(a);
        int m =a.size();
        out.println(m);
        for(int i=0;i<m;i++){
            out.print(a.get(i)+" ");
        }
        out.flush();;
    }
}
