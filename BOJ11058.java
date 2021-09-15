import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static long[] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            dp=new long[101];
            dp[1]=1;
            dp[2]=2;
            dp[3]=3;
            dp[4]=4;
            dp[5]=5;
            dp[6]=6;

            for(int i=1; i<=n; i++){
                int count=1;
                for(int j=i+3; j<=n; j++){
                    dp[j]=Math.max(dp[j], dp[i]+dp[i]*count++);
                }
            }
            System.out.println(dp[n]);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
