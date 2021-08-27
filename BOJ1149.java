import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] dp;
    static int[][] home;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            home=new int[n+1][3];
            dp=new int[n+1][3];
            for(int i=0; i<=n; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);

            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++)
                    home[i][j]=Integer.parseInt(st.nextToken());
            }
            dp[1][0]=home[1][0];
            dp[1][1]=home[1][1];
            dp[1][2]=home[1][2];
            for(int h=2; h<=n; h++){
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        if(i==j)
                            continue;

                        dp[h][i]=Math.min(dp[h][i], home[h][i]+dp[h-1][j]);
                    }
                }
            }
           
            int result=Integer.MAX_VALUE;
            for(int i=0; i<3; i++)
                result=Math.min(result, dp[n][i]);
            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
