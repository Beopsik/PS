import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static BigInteger[][][] dp;
    static int[][] board;
    static int[] dy={1, 0, 1};
    static int[] dx={1, 1, 0};
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dp=new BigInteger[n+1][n+1][3];
            board=new int[n+1][n+1];

            for(int i=0; i<=n; i++){
                for(int j=0; j<=n; j++)
                    Arrays.fill(dp[i][j],BigInteger.valueOf(-1));
            }

            for(int i=1; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++)
                    board[i][j]=Integer.parseInt(st.nextToken());
            }
            dp[n][n][0]=BigInteger.valueOf(1);
            dp[n][n][1]=BigInteger.valueOf(1);
            dp[n][n][2]=BigInteger.valueOf(1);
            dfs(1, 2, 1);

            BigInteger result=BigInteger.valueOf(0);
            for(int i=0; i<3; i++) {
                if(dp[1][2][i].equals(BigInteger.valueOf(-1)))
                    continue;
                result=result.add(dp[1][2][i]);
            }

            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static BigInteger dfs(int y, int x, int dir){
        if(!dp[y][x][dir].equals(BigInteger.valueOf(-1)))
            return dp[y][x][dir];

        dp[y][x][dir]=BigInteger.valueOf(0);
        if(y+dy[0]<=n&&x+dx[0]<=n&&board[y+dy[0]][x+dx[0]]!=1
                &&board[y+dy[1]][x+dx[1]]!=1&&board[y+dy[2]][x+dx[2]]!=1){
            dp[y][x][dir]=dp[y][x][dir].add(dfs(y+dy[0], x+dx[0], 0));
        }
        if(dir==0||dir==1){
            if(y+dy[1]<=n&&x+dx[1]<=n&&board[y+dy[1]][x+dx[1]]!=1)
                dp[y][x][dir]=dp[y][x][dir].add(dfs(y+dy[1], x+dx[1], 1));
        }
        if(dir==0||dir==2){
            if(y+dy[2]<=n&&x+dx[2]<=n&&board[y+dy[2]][x+dx[2]]!=1)
                dp[y][x][dir]=dp[y][x][dir].add(dfs(y+dy[2], x+dx[2], 2));
        }

        return dp[y][x][dir];
    }
}
