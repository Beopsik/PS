import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static String input;
    static String devil;
    static String angel;
    static int[][][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            input=br.readLine();
            devil="*";
            devil+=br.readLine();
            angel="*";
            angel+=br.readLine();

            dp=new int[3][21][101];

            int result=0;

            for(int i=0; i<=2; i++) {
                for (int j = 0; j <= 20; j++)
                    Arrays.fill(dp[i][j], -1);
            }
            result+=recur(0, 0, 1);
            for(int i=0; i<=2; i++) {
                for (int j = 0; j <= 20; j++)
                    Arrays.fill(dp[i][j], -1);
            }
            result+=recur(0, 0, 2);

            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int recur(int inputIdx, int bridgeIdx, int flag){
        if(dp[flag][inputIdx][bridgeIdx]!=-1)
            return dp[flag][inputIdx][bridgeIdx];

        if(inputIdx>=input.length())
            return 1;

        char curCh=input.charAt(inputIdx);

        dp[flag][inputIdx][bridgeIdx]=0;
        if(flag==1){
            int nextIdx=0;
            int fromFoundIdx=bridgeIdx+1;
            while(nextIdx!=-1) {
                nextIdx = devil.indexOf(curCh, fromFoundIdx);
                if (nextIdx > bridgeIdx)
                    dp[flag][inputIdx][bridgeIdx] += recur(inputIdx + 1, nextIdx, 2);
                fromFoundIdx=nextIdx+1;
            }
        }else{
            int nextIdx=0;
            int fromFoundIdx=bridgeIdx+1;
            while(nextIdx!=-1) {
                nextIdx = angel.indexOf(curCh, fromFoundIdx);
                if (nextIdx > bridgeIdx)
                    dp[flag][inputIdx][bridgeIdx] += recur(inputIdx + 1, nextIdx, 1);
                fromFoundIdx=nextIdx+1;
            }
        }

        return dp[flag][inputIdx][bridgeIdx];
    }
}
