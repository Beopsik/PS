import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, t;
    static int[][] dp;
    static int[] coin;
    static int result=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            t=Integer.parseInt(st.nextToken());
            for(int i=0; i<t; i++) {
                st=new StringTokenizer(br.readLine());
                n=Integer.parseInt(st.nextToken());

                dp = new int[10001][n+1];
                coin = new int[n+1];

                st=new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++)
                    coin[j]=Integer.parseInt(st.nextToken());

                st=new StringTokenizer(br.readLine());
                m=Integer.parseInt(st.nextToken());

                for(int j=1; j<=n; j++)
                    dp[coin[j]][j]=1;

                for(int bill=1; bill<=m; bill++){
                    for(int cIdx=1; cIdx<=n; cIdx++){
                        if(bill-coin[cIdx]<1)
                            continue;
                        for(int j=cIdx; j<=n; j++){
                            dp[bill][cIdx]+=dp[bill-coin[cIdx]][j];
                        }
                    }
                }

                int result=0;
                for(int j=1; j<=n; j++)
                    result+=dp[m][j];

                System.out.println(result);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
