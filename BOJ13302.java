import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static boolean[] check;
    static int[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{


            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            check=new boolean[101];

            if(m!=0) {
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= m; i++)
                    check[Integer.parseInt(st.nextToken())] = true;
            }

            dp=new int[101][101];
            for(int i=0; i<=100; i++)
                Arrays.fill(dp[i], -1);
            System.out.println(recur(1, 0));
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static int recur(int day, int couponNum){
        if(day>=n+1)
            return 0;

        if(dp[day][couponNum]!=-1)
            return dp[day][couponNum];

        if(check[day])
            dp[day][couponNum]=recur(day+1, couponNum);
        else{
            dp[day][couponNum]=Integer.MAX_VALUE;
            dp[day][couponNum]=Math.min(dp[day][couponNum], recur(day+1, couponNum)+10000);
            dp[day][couponNum]=Math.min(dp[day][couponNum], recur(day+3, couponNum+1)+25000);
            dp[day][couponNum]=Math.min(dp[day][couponNum], recur(day+5, couponNum+2)+37000);

            if(couponNum>=3)
                dp[day][couponNum]= Math.min(dp[day][couponNum], recur(day+1, couponNum-3));
        }
        return dp[day][couponNum];
    }
}
