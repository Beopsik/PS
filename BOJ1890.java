import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] board;
    static long[][] dp;
    static int[] dx={0 ,1};
    static int[] dy={1 ,0};
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            board=new int[n+1][n+1];
            dp=new long[n+1][n+1];

            for(int i=0; i<n; i++)
                Arrays.fill(dp[i], -1);

            dp[n-1][n-1]=1;

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++)
                    board[i][j]=Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            System.out.println(dp[0][0]);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static long dfs(int y, int x){
        if(dp[y][x]!=-1)
            return dp[y][x];

        dp[y][x]=0;

        for(int i=0; i<2; i++){
            if(y+dy[i]*board[y][x]>=0&&y+dy[i]*board[y][x]<n&&x+dx[i]*board[y][x]>=0&&x+dx[i]*board[y][x]<n){
                dp[y][x]+=dfs(y+dy[i]*board[y][x], x+dx[i]*board[y][x]);
            }
        }

        return dp[y][x];
    }
}
