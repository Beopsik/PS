import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static int[][] dp;
    static int Max;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            arr=new int[n+2][n+2];
            dp=new int[n+2][n+2];

            for(int i=1; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=1; j<=i; j++)
                    arr[i][j]=Integer.parseInt(st.nextToken());
            }
          
            bfs();
            System.out.println(Max);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void bfs() {
        dp[1][1]=arr[1][1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i+1][j]=Math.max(dp[i+1][j], dp[i][j]+arr[i+1][j]);
                dp[i+1][j+1]=Math.max(dp[i+1][j+1], dp[i][j]+arr[i+1][j+1]);
            }
        }
        for (int i=1; i<=n; i++)
            Max=Math.max(Max, dp[n][i]);
    }
}
