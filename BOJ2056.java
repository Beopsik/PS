import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;
    static int result=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dp=new int[n+1];

            st=new StringTokenizer(br.readLine());
            dp[1]=Integer.parseInt(st.nextToken());

            for(int i=2; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                int time=Integer.parseInt(st.nextToken());
                int preNum=Integer.parseInt(st.nextToken());

                int Max=0;
                for(int j=0; j<preNum; j++)
                    Max=Math.max(Max, dp[Integer.parseInt(st.nextToken())]);

                dp[i]=Max+time;
                result=Math.max(result, dp[i]);
            }

            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
