import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, k;
    static int[][] board;
    static int[][] dp;
    static int[] dx={1, 0};
    static int[] dy={0, 1};
    static int pathNum=1;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board=new int[n+1][m+1];
            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++) {
                    board[i][j] = m * (i - 1) + j;
                }
            }

            dp=new int[n+1][m+1];
            dp[1][1]=1;
            bfs();
            if(k==0)
                System.out.println(dp[n][m]);
            else{
                int x;
                int y;
                if(k%m==0){
                    y=k/m;
                    x=m;
                }else{
                    y=k/m+1;
                    x=k%m;
                }
                pathNum*=dp[y][x];
                pathNum*=dp[n-y+1][m-x+1];
                System.out.println(pathNum);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void bfs(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                for(int t=0; t<2; t++){
                    int tempY=i-dy[t];
                    int tempX=j-dx[t];
                    if(tempX>=1&&tempX<=m&&tempY>=1&&tempY<=n)
                        dp[i][j]+=dp[tempY][tempX];
                }
            }
        }
    }
}
