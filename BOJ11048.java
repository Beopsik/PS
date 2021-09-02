import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[][] maze;
    static int[][] dp;
    static int[] dx={0, 1, 1};
    static int[] dy={1, 0, 1};

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            maze=new int[1001][1001];
            dp=new int[1001][1001];

            for (int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=m; j++)
                    maze[i][j]=Integer.parseInt(st.nextToken());
            }

            for (int i=0; i<=n; i++)
                Arrays.fill(dp[i], -1);

            dp[n][m]=maze[n][m];
            dfs(1, 1);

            System.out.println(dfs(1, 1));
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static int dfs(int y, int x){
        if(dp[y][x]!=-1)
            return dp[y][x];

        for(int i=0; i<3; i++){
            int nextY=y+dy[i];
            int nextX=x+dx[i];
            if(nextY>=1&&nextY<=n&&nextX>=1&&nextX<=m){
                dp[y][x]=Math.max(dp[y][x], maze[y][x]+dfs(nextY, nextX));
            }
        }

        return dp[y][x];
    }
}
