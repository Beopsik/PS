import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            coin=new int[2];
            coin[0]=2;
            coin[1]=5;
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            dp=new int[100001];

            Arrays.fill(dp, Integer.MAX_VALUE);

            dp[1]=-1;
            dp[2]=1;
            dp[3]=-1;
            dp[4]=2;
            dp[5]=1;

            for(int i=6; i<=n; i++){
                if(dp[i]!=Integer.MAX_VALUE)
                    continue;

                for(int j=0; j<2; j++){
                    if(dp[i-coin[j]]==-1)
                        continue;
                    dp[i]=Math.min(dp[i], dp[i-coin[j]]+1);
                }
            }
            System.out.println(dp[n]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
