import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int d, k;
    static int[] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            dp=new int[d+2];
            dp[0]=1;
            dp[1]=1;
            dp[2]=2;
            for(int i=3; i<=d; i++)
                dp[i]=dp[i-1]+dp[i-2];

            int temp;
            for(int i=1; i<=k/dp[d-2]; i++){
                for(int j=1; j<=i; j++){
                    temp=dp[d-3]*j+dp[d-2]*i;
                    if(temp==k){
                        System.out.println(j);
                        System.out.println(i);
                        System.exit(0);
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
