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
        dp=new long[117];
        try{
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                dp[1]=1;
                dp[2]=1;
                dp[3]=1;
                dfs(4);

            System.out.println(dp[n]);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int index){
        if(index>n)
            return;

        dp[index]=dp[index-3]+dp[index-1];

        dfs(index+1);
    }
}
