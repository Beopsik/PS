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
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dp=new int[n+2];

            dp[1]=3;
            dp[2]=7;

            for(int i=3; i<=n; i++)
                dp[i]=(dp[i-1]*2+dp[i-2])%9901;

            System.out.println(dp[n]);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
