import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] num={0, 1, 2, 3};
    static long[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new long[100001][4];
        try{
            dp[1][1]=1;
            dp[2][2]=1;
            dp[3][1]=1;
            dp[3][2]=1;
            dp[3][3]=1;
            numWay();

            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());

            for(int i=0; i<tc; i++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                System.out.println((dp[n][1]+dp[n][2]+dp[n][3])% 1000000009);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void numWay(){

        for(int sum=4; sum<=100000; sum++) {
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i == j)
                        continue;

                    dp[sum][i] = (dp[sum][i] + dp[sum - num[i]][j]) % 1000000009;
                }
            }
        }
    }
}
