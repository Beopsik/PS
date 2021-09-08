import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;
    static int[] p;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            dp=new int[1001];
            p=new int[1001];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
                dp[i]=p[i];
            }

            minimum();

            System.out.println(dp[n]);


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void minimum(){

        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(i-j>=i/2)
                    dp[i]=Math.min(dp[i], dp[i-j]+p[j]);
            }
        }
    }
}
