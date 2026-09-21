import java.util.*;
import java.io.*;

public class P5740 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N = sc.nextInt();
        String[] name = new String[N];
        int[][] score = new int[N][3];
        int max =0;
        int maxcount=0;
        for(int i=0;i<N;i++){
            name[i] = sc.next();
            score[i][0]=sc.nextInt();
            score[i][1]=sc.nextInt();
            score[i][2]=sc.nextInt();
            int x=score[i][0]+score[i][1]+score[i][2];
            if(x>maxcount){
                max=i;
                maxcount=x;
            }
        }

        out.print(name[max]+" "+score[max][0]+" "+score[max][1]+" "+score[max][2]);
        out.flush();
        out.close();
    }

}
