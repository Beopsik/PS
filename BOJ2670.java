import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static double[] dp;
    static double[] temp;
    static double Max=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dp=new double[10001];
            dp[0]=0;

            temp=new double[10001];

            for(int i=1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());
                dp[i]=Double.parseDouble(st.nextToken());
                Max=Math.max(Max, dp[i]);
            }
            dfs( 1);

            /*for(int i=1; i<=n; i++)
                System.out.print(dp[i]+" ");*/
            System.out.println(String.format("%.3f", Max));

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static double dfs(int index){
        if(index==n+1)
            return 1;

        dp[index]=Math.max(dp[index], dp[index]*dfs(index+1));
        Max=Math.max(Max, dp[index]);

        return dp[index];
    }
}
