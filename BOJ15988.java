import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static long[] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new long[1000001];
        try{
            dp[1]=1;
            dp[2]=2;
            dp[3]=4;
            numWay();

            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());

            for(int i=0; i<tc; i++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                System.out.println((dp[n])% 1000000009);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void numWay(){
        for(int sum=4; sum<=1000000; sum++) {
            dp[sum] = (dp[sum-3]+dp[sum-2]+dp[sum-1]) % 1000000009;
        }
    }
}
