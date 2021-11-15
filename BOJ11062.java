import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int tc, n;
    static int[] card;
    static int[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            tc=Integer.parseInt(st.nextToken());
            for(int t=0; t<tc; t++){
                st = new StringTokenizer(br.readLine());
                n=Integer.parseInt(st.nextToken());

                card=new int[1001];
                dp=new int[1001][1001];

                st = new StringTokenizer(br.readLine());
                for(int i=1; i<=n; i++)
                    card[i]=Integer.parseInt(st.nextToken());

                System.out.println(dfs(1, n, 1));
            }


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int left, int right, int idx){
        if(dp[left][right]>0)
            return dp[left][right];

        if(idx%2==1){
            if(left==right)
                return dp[left][right]=card[left];

            return dp[left][right]=Math.max(dfs(left+1, right, idx+1)+card[left],
                                               dfs(left, right-1, idx+1)+card[right]);
        }else{
            if(left==right)
                return dp[left][right]=0;

            return dp[left][right]=Math.min(dfs(left+1, right, idx+1),
                                            dfs(left, right-1, idx+1));
        }
    }
}
