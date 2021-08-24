import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;
    static ArrayList<Integer> square;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dp=new int[500001];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0]=0;

            square=new ArrayList<>();
            square.add(0);

            for(int i=1; i*i<=n; i++) {
                square.add(i * i);
                dp[i*i]=1;
            }

            for(int i=2; i<=n; i++){
                if(dp[i]==1)
                    continue;

                for(int j=(int)Math.sqrt(i); j>=1; j--){
                    dp[i]=Math.min(dp[i], dp[i-square.get(j)]+1);
                }
            }
            System.out.println(dp[n]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
