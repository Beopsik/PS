import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int tc, k;
    static int[] novel;
    static int[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            tc=Integer.parseInt(st.nextToken());
            for(int t=0; t<tc; t++){
                st = new StringTokenizer(br.readLine());
                k=Integer.parseInt(st.nextToken());

                novel=new int[502];
                dp=new int[502][502];

                st = new StringTokenizer(br.readLine());
                for(int i=1; i<=k; i++) {
                    novel[i] = Integer.parseInt(st.nextToken());
                    novel[i]+=novel[i-1];
                }

                for(int i=k; i>=1; i--){
                    for(int j=i+1; j<=k; j++){
                        dp[i][j]=Integer.MAX_VALUE;
                        for(int l=i; l<=j; l++){
                            dp[i][j]=Math.min(dp[i][j], dp[i][l]+dp[l+1][j]+(novel[l]-novel[i-1])+(novel[j]-novel[l]));
                        }
                    }
                }
                System.out.println(dp[1][k]);
            }


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
