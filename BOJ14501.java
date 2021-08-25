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

    public void setTime(int time) {
        this.time = time;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
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

            counsel=new Pair[16];
            dp=new int[16];

            int time;
            int pay;
            for(int i=1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());

                time=Integer.parseInt(st.nextToken());
                pay=Integer.parseInt(st.nextToken());
                counsel[i]=new Pair(time, pay);
            }
            dfs( 1);

            System.out.println(Max);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int day){
        if(day==n+1)
            return;

        dfs(day+1);

        int possible=day+(counsel[day].getTime()-1);

        if(possible>n)
            return;

        dp[day]=counsel[day].getPay();
        for(int i=day+counsel[day].getTime(); i<=n; i++)
            dp[day]=Math.max(dp[day], counsel[day].getPay()+dp[i]);
        Max=Math.max(Max, dp[day]);
    }
}
