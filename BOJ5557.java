import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] nArr;
    static long[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            nArr=new int[n+1];

            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                nArr[i]=Integer.parseInt(st.nextToken());

            dp=new long[n+1][21];
            for(int i=0; i<=n; i++)
                Arrays.fill(dp[i], -1);

            dp[n-1][nArr[n]]=1;
            dfs(1, nArr[1] );
            System.out.println(dp[1][nArr[1]]);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static long dfs(int idx, int num){
        if(dp[idx][num]!=-1)
            return dp[idx][num];

        dp[idx][num]=0;

        if(num+nArr[idx+1]<=20&&idx+1<=n-1)
            dp[idx][num]+=dfs(idx+1,num+nArr[idx+1]);

        if(num-nArr[idx+1]>=0&&idx+1<=n-1)
            dp[idx][num]+=dfs(idx+1,num-nArr[idx+1]);

        return dp[idx][num];
    }
}
