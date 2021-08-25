import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new int[1000001];
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dp[1]=1;
            dp[2]=2;

            for(int i=3; i<=n; i++)
                dp[i]=(dp[i-1]+dp[i-2])%15746;

            System.out.println(dp[n]);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
