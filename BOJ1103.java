import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;

    static String[] array;
    static boolean[][] check;
    static int[][] dp;
    static int[] dy={1, 0, -1, 0};
    static int[] dx={0, 1, 0, -1};

    static int Max=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();

        array=new String[n+1];
        check=new boolean[n+1][m+1];
        dp=new int[n+1][m+1];

        for(int i=0; i<n; i++)
            array[i]=sc.nextLine();

        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);

        dfs(0, 0);
        System.out.println(Max);
    }
    public static int dfs(int y, int x){
        if(dp[y][x]!=-1)
            return dp[y][x];
        dp[y][x]=1;
        check[y][x]=true;

        for(int i=0; i<4; i++){
            int nextY=y+(dy[i]*(array[y].charAt(x)-'0'));
            int nextX=x+(dx[i]*(array[y].charAt(x)-'0'));
            if(nextY>=0&&nextY<n&&nextX>=0&&nextX<m){
                if(check[nextY][nextX]){
                    System.out.println(-1);
                    System.exit(0);
                }
                if(array[nextY].charAt(nextX)!='H') {
                    int result = 1;
                    result += dfs(nextY, nextX);
                    dp[y][x] = Math.max(dp[y][x], result);
                    if (dp[y][x] > Max)
                        Max = dp[y][x];
                }
            }
        }
        check[y][x]=false;
        return dp[y][x];
    }
}
