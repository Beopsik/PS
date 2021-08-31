import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k;
    static ArrayList<Integer> coin;
    static int[][] dp;
    static int count;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            coin=new ArrayList<>();
            dp=new int[k+1][n+1];

            coin.add(0);
            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                coin.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(coin);

            for(int i=1; i<=coin.size()-1; i++) {
                if(coin.get(i)<=k)
                    dp[coin.get(i)][i] = 1;
            }

            for(int i=1; i<=k; i++){
                for(int j=1; j<=coin.size()-1; j++){
                    int coinTemp=coin.get(j);
                    for(int t=1; t<=j; t++) {
                        if(i-coinTemp>=1)
                            dp[i][j] += dp[i - coinTemp][t];
                    }
                }
            }

            for (int i=1; i<=coin.size()-1; i++){
                count+=dp[k][i];
            }

            System.out.println(count);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
