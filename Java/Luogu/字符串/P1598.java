import java.util.*;
import java.io.*;

public class P1598{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] cnt = new int[26];
        for(int n=0;n<4;n++){
            String line = sc.nextLine();
            for(int i=0;i<line.length();i++){
                char x = line.charAt(i);
                if(x>='A' && x<='Z'){
                    cnt[x-'A']++;
                }
            }
        }
        int max=0;
        for(int i=0;i<26;i++){
            max = Math.max(max,cnt[i]);
        }

        
        char[][] result = new char[max][26];
        for(int i=0;i<26;i++){
            for(int j=max-1;j>=0;j--){
                
                if(cnt[i]>0){
                    result[j][i]='*';
                    cnt[i]--;
                }
                else{
                    result[j][i]=' ';
                }
            }
        }
        for(int i=0;i<max;i++){
            for(int j=0;j<26;j++){
                if(j<25)
                    out.print(result[i][j]+" ");
                else
                    out.print(result[i][j]);
            }
            out.println();
        }

        for(int i=0;i<26;i++){
            if(i<25)
                out.print((char)('A'+i)+" ");
            else
                out.print((char)('A'+i));
        }
        out.flush();
        out.close();

        
    }
}