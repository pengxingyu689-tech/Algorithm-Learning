import java.util.*;
import java.io.*;

public class P2415 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long x=1,sum=0;
        while(sc.hasNextLong()){
            sum+=sc.nextLong();
            x*=2;
        }
        sc.close();
        out.print(sum*x/2);
        out.flush();
        
    }
}
