import java.util.*;
import java.io.*;

public class P1106 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String line = sc.next();
        int k = sc.nextInt();
        char[] stk = new char[line.length()];
        int top=0;
        for(char c : line.toCharArray()){
            while(top>0 && k>0 && stk[top-1]>c){
                top--;
                k--;
            }
            stk[top++]=c;
        }

        while(k>0){
            top--;
            k--;
        }
        int start=0;
        while(stk[start]=='0'){
            start++;
        }
        if(start==top)
            out.print(0);
        for(int i=start;i<top;i++){
            out.print(stk[i]);
        }
        
        
        out.flush();
    }
}
