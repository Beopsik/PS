import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;
    static int Max;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new int[1001];
        try{
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());

            for(int i=0; i<tc; i++) {
                Max=Integer.MIN_VALUE;
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++)
                    dp[j]=Integer.parseInt(st.nextToken());

                dfs(0);

                System.out.println(Max);

            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int index){
        if(index==n)
            return 0;

        dp[index]=Math.max(dp[index], dp[index]+dfs(index+1));
        Max=Math.max(Max, dp[index]);

        return dp[index];
    }
}
