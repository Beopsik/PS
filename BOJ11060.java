import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[]dp;
    static int[]arr;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new int[1001];
        Arrays.fill(dp, 1001);
        arr=new int[1001];
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                arr[i]=Integer.parseInt(st.nextToken());

            dp[n]=0;
            dfs(1);
            if(dp[1]!=1001)
                System.out.println(dp[1]);
            else
                System.out.println(-1);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int index){
        if(index>=n)
            return 0;

        if(dp[index]!=1001)
            return dp[index];

        for(int i=1; i<=arr[index]; i++){
            if(index+i<=n) {
                int result = 1;
                result += dfs(index + i);
                dp[index] = Math.min(dp[index], result);
            }
        }
        return dp[index];
    }
}
