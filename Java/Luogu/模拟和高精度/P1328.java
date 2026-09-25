import java.util.*;
import java.io.*;

public class P1328 {
    static int scoreA =0;
    static int scoreB=0;

    static void game(int a,int b){
        if(a==b) return;
        else if(a==0){
            if(b==1){
                scoreB++;
                return;
            }
            if(b==2){
                scoreA++;
                return;
            }
            if(b==3){
                scoreA++;
                return ;
            }
            if(b==4){
                scoreB++;
                return ;
            }
        }
        else if(a==1){
            if(b==0){
                scoreA++;
                return ;
            }
            if (b==2) {
                scoreB++;
                return ;
            }
            if(b==3){
                scoreA++;
                return ;
            }
            if(b==4){
                scoreB++;
                return ;
            }
        }
        else if(a==2){
            if(b==0){
                scoreB++;
                return ;
            }
            if (b==1) {
                scoreA++;
                return ;
            }
            if(b==3){
                scoreB++;
                return ;
            }
            if(b==4){
                scoreA++;
                return ;
            }
        }
        else if(a==3){
            if(b==0){
                scoreB++;
                return ;
            }
            if (b==1) {
                scoreB++;
                return ;
            }
            if(b==2){
                scoreA++;
                return ;
            }
            if(b==4){
                scoreA++;
                return ;
            }
        }
        else if(a==4){
            if(b==0){
                scoreA++;
                return ;
            }
            if (b==1) {
                scoreA++;
                return ;
            }
            if(b==2){
                scoreB++;
                return ;
            }
            if(b==3){
                scoreB++;
                return ;
            }
        }

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt();
        int Na = sc.nextInt();
        int Nb = sc.nextInt();
        int[] A = new int[Na];
        int[] B = new int[Nb];
        for(int i=0;i<Na;i++){
            A[i]=sc.nextInt();
        }
        for(int i=0;i<Nb;i++){
            B[i]=sc.nextInt();
        }

        for(int i = 0;i<N;i++){
            game(A[i%Na],B[i%Nb]);
        }

        out.print(scoreA+" "+scoreB);
        out.flush();
    }
}
