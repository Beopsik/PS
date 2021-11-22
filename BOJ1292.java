import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            dp=new int[1001];

            int num=1;
            int idx=0;
            while(true){
                for(int i=1; i<=num; i++){
                    if(idx>=1000)
                        break;
                    dp[idx+1]+=num+dp[idx];
                    idx++;
                }
                num++;
                if(idx>=1000)
                    break;
            }

            System.out.println(dp[m]-dp[n-1]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
