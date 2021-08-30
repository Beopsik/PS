import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, s, m;
    static BigInteger[] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        dp = new BigInteger[251];
        dp[0]=BigInteger.valueOf(1);
        dp[1]=BigInteger.valueOf(1);
        dp[2]=BigInteger.valueOf(3);
        fill();

        try{
            while (true) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                System.out.println(dp[n]);
            }
        }catch (Exception e){
            System.exit(0);
        }
    }
    public static void fill(){

        for(int i=3; i<=250; i++)
            dp[i]=dp[i-1].add(dp[i-2].multiply(BigInteger.valueOf(2)));
    }
}
