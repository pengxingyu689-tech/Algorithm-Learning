import java.util.*;
import java.io.*;

public class P1042{
    static   PrintWriter out = new PrintWriter(System.out);
    public static void game21(String s){
        int n=0,m=0;
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x=='W')  n++;
            else if(x=='L') m++;
            else if(x=='E'){
                out.println(n+":"+m);
                return;

            }

            if((n>=21 || m>=21) && Math.abs(n-m)>=2){
                out.println(n+":"+m);
                n=m=0;
            }
        }
    }

    public static void game11(String s){
        int n=0,m=0;
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x=='W')  n++;
            else if(x=='L') m++;
            else if(x=='E'){
                out.println(n+":"+m);
                return;
            }

            if((n>=11 || m>=11) && Math.abs(n-m)>=2){
                out.println(n+":"+m);
                n=m=0;
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s=" ";
        while(sc.hasNext()){
            s+=sc.next();
        }
        game11(s);
        out.println();
        game21(s);
        out.flush();
    }
}