import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, n;
    static long[][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            t=Integer.parseInt(st.nextToken());

            dp = new long[5001][5002];
            dp[2][2]=1;
            dp[2][3]=1;
            dp[4][2]=1;
            dp[4][4]=1;
            dp[4][5]=2;
            for(int i=6; i<=5000; i+=2){
                dp[i][2]=dp[i-2][i-1];
                dp[i][i]=dp[i-2][i-1];
                for(int j=4; j<i; j+=2){
                    dp[i][j] += (dp[i - j][i-j+1]*dp[j][j])%1000000007;
                    dp[i][j]%=1000000007;
                }
                for(int j=2; j<=i; j+=2){
                    dp[i][i+1]+=dp[i][j];
                    dp[i][i+1]%=1000000007;
                }
            }

            for(int tc=0; tc<t; tc++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                System.out.println(dp[n][n+1]);
            }


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
