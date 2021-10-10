import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, n, k;
    static int[][][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            t=Integer.parseInt(st.nextToken());

            dp = new int[101][101][2];

            dp[2][1][1]=1;
            dp[2][1][0]=0;
            dp[2][0][1]=1;
            dp[2][0][0]=2;

            for(int i=3; i<=100; i++){
                dp[i][0][0]=dp[i-1][0][0]+dp[i-1][0][1];
                dp[i][0][1]=dp[i-1][0][0];
                for(int j=1; j<i-1; j++){
                    dp[i][j][0]=dp[i-1][j][1]+dp[i-1][j][0];
                    dp[i][j][1]=dp[i-1][j][0]+dp[i-1][j-1][1];
                }
                dp[i][i-1][1]=1;
                dp[i][i-1][0]=0;
            }
            for(int tc=0; tc<t; tc++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                System.out.println(dp[n][k][0]+dp[n][k][1]);
            }


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
