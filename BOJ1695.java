import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static ArrayList<Integer> arr;
    static int[][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            arr=new ArrayList<>();
            dp=new int[n+1][n+1];

            for(int i=0; i<=n; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);

            st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(st.nextToken()));
            dfs(0, n-1);
            System.out.println(dp[0][n-1]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int left, int right){
        if(left>=right) {
            dp[left][right]=0;
            return dp[left][right];
        }

        if(dp[left][right]!=Integer.MAX_VALUE)
            return dp[left][right];

        if(!arr.get(left).equals(arr.get(right))){
            dp[left][right]=Math.min(dp[left][right], 1+dfs(left+1, right));
            dp[left][right]=Math.min(dp[left][right], 1+dfs(left, right-1));
        }else{
            dp[left][right]=dfs(left+1, right-1);
        }

        return dp[left][right];
    }
}
