import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, t;
    static long[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new long[31][31];
        for(int i=0; i<=30; i++)
            Arrays.fill(dp[i], -1);
        dp[1][0]=1;
        dp[0][1]=1;
        dp[0][0]=1;
        eatTablet(30, 0);
        try{
            while(true) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                if(n==0)
                    break;
                System.out.println(dp[n][0]);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static long eatTablet(int tNum, int hTNum){
        if(tNum+hTNum==0)
            return 1;

        if(dp[tNum][hTNum]!=-1)
            return dp[tNum][hTNum];

        dp[tNum][hTNum]=0;

        if(tNum>0)
            dp[tNum][hTNum]+=eatTablet(tNum-1, hTNum+1);
        if(hTNum>0)
            dp[tNum][hTNum]+=eatTablet(tNum, hTNum-1);

        return dp[tNum][hTNum];
    }
}
