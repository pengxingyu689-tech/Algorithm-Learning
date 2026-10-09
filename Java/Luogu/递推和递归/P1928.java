import  java.util.*;
import  java.io.*;

public class P1928 {
    static int index=0;
    static String dfs(String s){
        StringBuilder res = new StringBuilder();
        while(index<s.length()){
            char c = s.charAt(index);
            if(c<='Z' && c>='A'){
                res.append(c);
                index++;
            }
            else if(c=='['){
                index++;
                int num = s.charAt(index)-'0';
                index++;
                if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                    num=10*num+(s.charAt(index)-'0');
                    index++;
                }
                String temp = dfs(s);
                for(int i=0;i<num;i++){
                    res.append(temp);
                }

                
            }
            else if(c==']'){
                index++;
                break;}
        }
        return res.toString();
       
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s = sc.next();
        out.println(dfs(s));
        out.flush();
    }
}
