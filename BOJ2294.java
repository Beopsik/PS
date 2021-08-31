import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k;
    static ArrayList<Integer> coin;
    static long[][] dp;
    static long Min=Integer.MAX_VALUE;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            coin=new ArrayList<>();
            dp=new long[k+1][n+1];

            coin.add(0); //dummy value for pretty index
            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                coin.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=1; i<=k; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);

            Collections.sort(coin);

            for(int i=1; i<=coin.size()-1; i++) {
                if(coin.get(i)<=k)
                    dp[coin.get(i)][i] = 1;
            }

            for(int coinSum=1; coinSum<=k; coinSum++){
                for(int coinIdx=1; coinIdx<=coin.size()-1; coinIdx++){
                    int coinTemp=coin.get(coinIdx);
                    for(int i=1; i<=coinIdx; i++) {
                        if(coinSum-coinTemp>=1)
                            dp[coinSum][coinIdx] = Math.min(dp[coinSum][coinIdx], dp[coinSum - coinTemp][i]+1);
                    }
                }
            }

            for (int i=1; i<=coin.size()-1; i++){
                Min=Math.min(Min, dp[k][i]);
            }

            if(Min==Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(Min);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
