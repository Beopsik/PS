import java.util.*;

public class Main {

    static int[][] array;
    static int[][] dp;
    static int n, m;

    static int[] dy={1, 0, -1, 0};
    static int[] dx={0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        array=new int[n][m];
        dp=new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array[i][j]=sc.nextInt();
                dp[i][j]=-1;
            }
        }
        dp[n-1][m-1]=1;
        dfs(0, 0);
        System.out.println(dp[0][0]);
    }
    public static int dfs(int y, int x){
        if(dp[y][x]!=-1) {
            return dp[y][x];
        }
        dp[y][x]=0;

        for(int i=0; i<4; i++){
            if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m){
                if(array[y+dy[i]][x+dx[i]]<array[y][x]){
                    dp[y][x]+=dfs(y+dy[i],x+dx[i]);
                }
            }
        }

        return dp[y][x];
    }
}
