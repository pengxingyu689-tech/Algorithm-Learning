import java.util.*;
import java.io.*;

public class P1098 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int p1 =sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        String line = sc.next();
        int pos=0;
        while(line.indexOf("-",pos)!=-1){
            int i = line.indexOf("-",pos);
            if(i==0){
                pos=i+1;
                continue;
            }
            if(i==line.length()-1){
                break;
            }
            char n = line.charAt(i-1);
            char m = line.charAt(i+1);
            boolean ischar =(n>='a' && n<='z' && m>='a' && m<='z');
            boolean isnum =(n>='0' && n<='9' && m>='0' && m<='9');
            String s="-";
            
            if((ischar || isnum) && m>n){
                    s="";
                    if(p1==1){
                        for(int q=1;q<m-n;q++){
                            for(int j=0;j<p2;j++){
                                s+=(char)(n+q);
                            }
                        }
                    }
                    else if(p1==2){
                        if(ischar){
                        for(int q=1;q<m-n;q++){
                            for(int j=0;j<p2;j++){
                                s+=Character.toUpperCase((char)(n+q));
                            }
                        }
                    }
                        else{
                            for(int q=1;q<m-n;q++){
                            for(int j=0;j<p2;j++){
                                s+=(char)(n+q);
                            }
                        }
                        }
                    }
                
                    else if(p1==3){
                        for(int q=1;q<m-n;q++){
                                for(int j=0;j<p2;j++){
                                    s+="*";
                                }
                            }
                }
                if(p3==2){
                    s=new StringBuilder(s).reverse().toString();
                }
            }
            pos=i+1;
            line = line.substring(0,i)+s+line.substring(i+1);

        }
        out.print(line);
        out.flush();
        
    }
}
