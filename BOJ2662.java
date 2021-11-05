import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] dp;
    static int[][] corp;
    static int[][] invest;
    static int n, m;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            dp=new int[m+1][n+1];
            corp=new int[m+1][n+1];
            invest=new int[m+1][n+1];

            for(int i=1; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                Integer.parseInt(st.nextToken());
                for(int j=1; j<=m; j++){
                    corp[j][i]=Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1; i<=m; i++)
                Arrays.fill(dp[i], -1);

            dfs(1, n);
            System.out.println(dp[1][n]);

            for(int i=1; i<=m; i++){
                System.out.print(invest[i][n]+" ");
                n-=invest[i][n];
            }
            System.out.println();


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int corIdx, int money){
        if(corIdx>m||money<0)
            return 0;

        if(dp[corIdx][money]!=-1)
            return dp[corIdx][money];

        for(int i=0; i<=money; i++){
            int temp=dp[corIdx][money];
            dp[corIdx][money]=Math.max(dp[corIdx][money], corp[corIdx][i]+dfs(corIdx+1, money-i));
            if(temp!=dp[corIdx][money]){
                invest[corIdx][money]=i;
            }
        }

        return dp[corIdx][money];
    }
}
