import java.util.*;
import java.io.*;


public class P1518 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int[][] dirt = {{-1,0},{0,1},{1,0},{0,-1}};
        char[][] table = new char[10][10];
        int xf=0;
        int yf=0;
        int xc=0;
        int yc=0;
        int dirc=0;
        int dirf=0;
        int res=0;


        for(int i=0;i<10;i++){
            String line = sc.next();
            for(int j=0;j<10;j++){
                char c = line.charAt(j);
                table[i][j] = c;
                if(c=='F'){
                    xf=i;yf=j;
                }
                if(c=='C'){
                    xc=i;yc=j;
                }
            }
        }
        
        for(int i=0;res<1000000;i++){
            res++;
            int x1=xf+dirt[dirf][0];
            int y1=yf+dirt[dirf][1];
            int x2=xc+dirt[dirc][0];
            int y2=yc+dirt[dirc][1];
            if(x1>=0 && x1<10 && y1>=0 && y1<10 && table[x1][y1]!='*' ){
                xf=x1;
                yf=y1;
            }
            else{
                dirf = (dirf+1)%4;
            }
            if(x2>=0 && x2<10 && y2>=0 && y2<10 && table[x2][y2]!='*' ){
                xc=x2;
                yc=y2;
            }
            else{
                dirc = (dirc+1)%4;
            }

            if(xc==xf && yc==yf){
                out.print(res);
                out.flush();
                return;
            }

        }
        out.print((0));
        out.flush();


    }
}
