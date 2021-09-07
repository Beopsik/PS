import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    int time;
    int pay;

    public Pair(int time, int pay){
        this.time=time;
        this.pay=pay;
    }

    public int getTime() {
        return time;
    }

    public int getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "time=" + time +
                ", pay=" + pay +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static Pair[] counsel;
    static int[] dp;
    static int Max=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            counsel=new Pair[1500002];
            dp=new int[1500002];

            int time;
            int pay;
            for(int i=1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());

                time=Integer.parseInt(st.nextToken());
                pay=Integer.parseInt(st.nextToken());
                counsel[i]=new Pair(time, pay);
            }

            for(int i=1; i<=n; i++){
                if(dp[i+1]<dp[i]) {
                    dp[i + 1] = dp[i];
                    Max=Math.max(Max, dp[i+1]);
                }

                int curPay;
                int curTime;
                if(i+counsel[i].getTime()-1<=n) {
                    curPay = counsel[i].getPay();
                    curTime = counsel[i].getTime();
                }else
                    continue;

                if(dp[i+curTime]<dp[i]+curPay){
                    dp[i+curTime]=dp[i]+curPay;
                    Max=Math.max(Max, dp[i+curTime]);
                }

            }
            System.out.println(Max);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
