import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dp=new int[1001][2][3];
            for(int i=0; i<=1000; i++){
                for(int j=0; j<=1; j++)
                    Arrays.fill(dp[i][j], -1);
            }

            System.out.println(dfs(0, 0, 0)%1000000);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int index, int lNum, int aNum){
        if(lNum>=2)
            return 0;
        if(aNum>=3)
            return 0;

        if(index==n)
            return 1;
        if(dp[index][lNum][aNum]!=-1)
            return dp[index][lNum][aNum];

        dp[index][lNum][aNum]=(dfs(index+1, lNum, 0)%1000000)+(dfs(index+1, lNum+1, 0)%1000000)+(dfs(index+1, lNum, aNum+1)%1000000);

        return dp[index][lNum][aNum];
    }
}
