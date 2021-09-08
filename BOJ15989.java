import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, n;
    static int[][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new int[10001][4];
        numWay();
        try{
            st = new StringTokenizer(br.readLine());
            t=Integer.parseInt(st.nextToken());
            for(int tc=0; tc<t; tc++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);
            }

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void numWay(){
        dp[1][1]=1;
        dp[2][1]=1;
        dp[2][2]=1;
        dp[3][1]=2;
        dp[3][3]=1;

        for(int sum=4; sum<=10000; sum++){
            for(int i=1; i<=3; i++){
                for(int j=i; j<=3; j++) {
                    dp[sum][i] += dp[sum - i][j];
                }
            }
        }
    }
}
