import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int tc, n, m;
    static long[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            tc = Integer.parseInt(st.nextToken());
            dp=new long[31][31];
            dp[1][0] = 1;
            dp[1][1] = 1;

            int mTemp=0;
            for(int TC=0; TC<tc; TC++) {
                st = new StringTokenizer(br.readLine());
                n=Integer.parseInt(st.nextToken());
                m=Integer.parseInt(st.nextToken());

                if(mTemp<m) {
                    dfs(2);
                }
                System.out.println(dp[m][n]);
                mTemp=m;
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static void dfs(int index){
        if(index==m+1)
            return;

        dp[index][0]=1;
        dp[index][index]=1;
        for(int i=1; i<index; i++)
            dp[index][i]=dp[index-1][i]+dp[index-1][i-1];

        dfs(index+1);
    }
}
