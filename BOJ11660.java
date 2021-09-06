import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;
    static int[][] board;
    static int[][] dp;
    static int x1, y1, x2, y2;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb=new StringBuilder();

            board=new int[1025][1025];
            dp=new int[1025][1025];

            for (int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j]=board[i][j]+dp[i][j-1];
                }
            }

            for(int i=1; i<=m; i++){
                int sum=0;

                st = new StringTokenizer(br.readLine());
                x1=Integer.parseInt(st.nextToken());
                y1=Integer.parseInt(st.nextToken());
                x2=Integer.parseInt(st.nextToken());
                y2=Integer.parseInt(st.nextToken());

                for(int x=x1; x<=x2; x++)
                    sum+=dp[x][y2]-dp[x][y1-1];
                
                sb.append(sum).append("\n");
            }
            System.out.println(sb);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
