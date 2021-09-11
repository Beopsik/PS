import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, t;
    static long[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new long[65][11];
        for(int i=0; i<=9; i++)
            dp[1][i]=1;
        noDecline();
        try{
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());

            for(int tc=1; tc<=t; tc++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                long result=0;
                for(int i=0; i<=9; i++)
                    result+=dp[n][i];

                System.out.println(result);
            }

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static void noDecline(){

        for(int i=2; i<=64; i++){
            for(int j=0; j<=9; j++){
                for(int t=0; t<=j; t++)
                    dp[i][j]+=dp[i-1][t];
            }
        }
    }
}
