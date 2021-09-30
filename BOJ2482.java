import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k;
    static int[][] dp;
    static int mod=1000000003;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());

            if((n+1)/2<k){
                System.out.println(0);
            }else {
                dp = new int[1001][1001];

                for (int i = 1; i <= n; i++)
                    dp[i][1] = i;

                for (int i = 4; i <= n; i++) {
                    for (int j = 2; j <= k; j++) {
                        dp[i][j] = dp[i - 2][j - 1] % mod + dp[i - 1][j] % mod;
                        dp[i][j] %= mod;
                    }
                }

                System.out.println(dp[n][k]);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
