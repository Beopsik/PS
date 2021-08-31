import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;
    static int[] stone={4, 3, 1};

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new int[1001];
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            Arrays.fill(dp, 1);

            dp[1]=1;
            dp[2]=0;
            dp[3]=1;
            dp[4]=0;
            dp[5]=0;
            dfs(6);

            /*for (int i=1; i<=n; i++)
                System.out.print(dp[i]+" ");
            System.out.println();*/

            if(dp[n]==0)
                System.out.println("SK");
            else
                System.out.println("CY");

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int num){
        if(num==1001)
            return;

        for(int i=0; i<3; i++){
            if(dp[num-stone[i]]==1) {
                dp[num] = 0;
                break;
            }
        }
        dfs(num+1);
    }
}
