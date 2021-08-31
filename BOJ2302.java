import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[] dp;
    static int[] vipSeat;
    static int result=1;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            dp=new int[n+2];
            dp[0]=1;
            dp[1]=1;
            dp[2]=2;
            for(int i=3; i<=n; i++)
                dp[i]=dp[i-1]+dp[i-2];

            vipSeat=new int[n+2];
            for(int i=1; i<=m; i++){
                st = new StringTokenizer(br.readLine());
                vipSeat[i]=Integer.parseInt(st.nextToken());
            }

            for (int i=1; i<=m; i++)
                result*=dp[vipSeat[i]-vipSeat[i-1]-1];
            result*=dp[n-vipSeat[m]];

            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
