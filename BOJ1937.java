import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;

    static int[][] array;
    static int[][] dp;

    static int[] dy={1, 0, -1, 0};
    static int[] dx={0, 1, 0, -1};
    static int Max=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        array=new int[n+1][n+1];
        dp=new int[n+1][n+1];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                array[i][j]=sc.nextInt();
        }
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j]==-1)
                    dfs(i, j);
            }
        }
        System.out.println(Max);
    }
    public static int dfs(int y, int x){
        if(dp[y][x]!=-1)
            return dp[y][x];
        dp[y][x]=1;

        for(int i=0; i<4; i++){
            if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<n){
                if(array[y+dy[i]][x+dx[i]]>array[y][x]){
                    int result=1;
                    result+=dfs(y+dy[i], x+dx[i]);
                    dp[y][x]=Math.max(dp[y][x],result);
                    if(dp[y][x]>Max)
                        Max=dp[y][x];
                }
            }
        }
        return dp[y][x];
    }
}
