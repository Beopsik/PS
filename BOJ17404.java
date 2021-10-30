import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static long[][] dp;
    static long[][] home;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            home=new long[n+1][3];
            dp=new long[n+1][3];
            for(int i=0; i<=n; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);

            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++)
                    home[i][j]=Integer.parseInt(st.nextToken());
            }


            long result=Integer.MAX_VALUE;
            for(int t=0; t<3; t++) {
                for(int i=0; i<=n; i++)
                    Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[1][t] = home[1][t];
                for (int h = 2; h <= n; h++) {
                    for (int i = 0; i < 3; i++) {
                        if(h==n&&(i==t))
                            continue;
                        for (int j = 0; j < 3; j++) {
                            if (i == j)
                                continue;

                            dp[h][i] = Math.min(dp[h][i], home[h][i] + dp[h - 1][j]);
                        }
                    }
                }
                for(int i=0; i<3; i++)
                    result=Math.min(result, dp[n][i]);
            }

            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
