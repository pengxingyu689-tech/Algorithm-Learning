import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class P1601 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());

        out.print(a.add(b));
        out.flush();
        out.close();

    }
}
