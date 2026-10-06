import java.util.*;
import java.io.*;

public class P3654 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int r,c,k;
        int count=0;
        r=sc.nextInt();
        c=sc.nextInt();
        k=sc.nextInt();
        sc.nextLine();
        char[][] a = new char[r][c];
        for(int i=0;i<r;i++){
            String line = sc.nextLine();
            for(int j=0;j<c;j++){
                a[i][j] = line.charAt(j);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j]=='#')
                    continue;
                boolean flagx=true;
                boolean flagy=true;
                if(k==1 && a[i][j]=='.'){
                    count++;
                    continue;
                }
                for(int x=1;x<k;x++){
                    if(j+x>=c || a[i][j+x]=='#')
                        flagx=false;
                    if(i+x>=r || a[i+x][j]=='#')
                        flagy=false;  
                }
                if(flagx)
                    count++;
                if(flagy)
                    count++;
            }
        }

        out.println(count);
        out.flush();
    }
}
