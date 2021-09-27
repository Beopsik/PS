import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[][] dp;
    static int result=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            dp=new int[n+1][m+1];

            for(int i=1; i<=n; i++){
                String temp=br.readLine();
                for(int j=1; j<=m; j++) {
                    int value=Character.getNumericValue(temp.charAt(j - 1));
                    dp[i][j] = value;
                }
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){
                    if(dp[i][j]==0)
                        continue;

                    int temp;
                    if(n-1>=1&&m-1>=1){
                        temp=Math.min(dp[i-1][j], dp[i-1][j-1]);
                        dp[i][j]+=Math.min(temp, dp[i][j-1]);
                    }
                    result=Math.max(result, dp[i][j]);
                }
            }
            System.out.println(result*result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
