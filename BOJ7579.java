import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[] memory;
    static int[] cost;
    static int[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            memory=new int[101];
            cost=new int[101];
            dp=new int[101][100001];

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                memory[i] = Integer.parseInt(st.nextToken());
            }

            int cSum=0;
            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                cSum+=cost[i];
            }

            dp[1][cost[1]]=memory[1];
            for(int i=2; i<=n; i++){
                for(int j=0; j<=cSum; j++){
                    dp[i][j]=dp[i-1][j];
                    if(j-cost[i]>=0)
                        dp[i][j]=Math.max(dp[i][j], dp[i-1][j-cost[i]]+memory[i]);
                }
            }
            for(int i=1; ; i++){
                if(dp[n][i]>=m) {
                    System.out.println(i);
                    break;
                }
            }

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
