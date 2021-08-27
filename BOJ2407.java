import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static BigInteger[][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            dp=new BigInteger[101][101];
            Combination();

            System.out.println(dp[n][m]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void Combination(){
        dp[1][1]=BigInteger.valueOf(1);
        dp[2][0]=BigInteger.valueOf(1);
        dp[2][1]=BigInteger.valueOf(2);
        dp[2][2]=BigInteger.valueOf(1);

        for(int i=3; i<=100; i++){
            dp[i][0]=BigInteger.valueOf(1);
            dp[i][i]=BigInteger.valueOf(1);
            for(int j=1; j<i; j++){
                dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
            }
        }
    }
}
