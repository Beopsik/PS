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
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dp=new long[36];
            dp[0]=1;

            for(int i=1; i<=n; i++) {
                for(int j=0; j<i; j++)
                    dp[i]+=dp[j]*dp[i-j-1];
            }
            System.out.println(dp[n]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
