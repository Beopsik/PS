import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] left;
    static int[] right;
    static int[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            left=new int[n+2];
            right=new int[n+2];
            dp=new int[2002][2002];

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++)
                left[i]=Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++)
                right[i]=Integer.parseInt(st.nextToken());

            for (int i=0; i<=n; i++)
                Arrays.fill(dp[i], -1);

            System.out.println(dfs(1, 1));
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static int dfs(int leftIndex, int rightIndex){
        if(leftIndex==n+1||rightIndex==n+1)
            return 0;

        if(dp[leftIndex][rightIndex]!=-1)
            return dp[leftIndex][rightIndex];

        if(left[leftIndex]>right[rightIndex])
            dp[leftIndex][rightIndex] = right[rightIndex]+dfs(leftIndex, rightIndex + 1);
        else
            dp[leftIndex][rightIndex] = Math.max(dfs(leftIndex+1, rightIndex+1), dfs(leftIndex+1, rightIndex));

        return dp[leftIndex][rightIndex];
    }
}
