import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, k;
    static int[][] dp;
    static BigInteger[] factorial;
    static String result="";

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            factorial=new BigInteger[201];
            factorial[0]=BigInteger.valueOf(1);
            factorial[1]=BigInteger.valueOf(1);
            for(int i=2; i<=200; i++){
                factorial[i]=factorial[i-1].multiply(BigInteger.valueOf(i));
            }
            dp=new int[101][101];
            for(int i=0; i<=n; i++){
                for(int j=0; j<=m; j++){
                    if(BigInteger.valueOf(1000000000).compareTo(factorial[i+j].divide(factorial[i].multiply(factorial[j])))<1)
                        dp[i][j]=1000000001;
                    else
                        dp[i][j]=factorial[i+j].divide(factorial[i].multiply(factorial[j])).intValue();
                }
            }

            int aNum=0;
            int zNum=0;
            int left=0;
            int right=dp[n][m];
            if(k>right)
                System.out.println(-1);
            else {
                while (true) {
                    if(k<=left+dp[n - (aNum + 1)][m - (zNum)]){
                        right = right-dp[n - (aNum)][m - (zNum + 1)];
                        aNum += 1;
                        result += "a";
                    } else{
                        left = left+dp[n - (aNum+1)][m - (zNum)];
                        zNum += 1;
                        result += "z";
                    }

                    if (aNum == n || zNum == m)
                        break;
                }

                if (aNum == n) {
                    for (int i = zNum; i < m; i++)
                        result += "z";
                } else {
                    for (int i = aNum; i < n; i++)
                        result += "a";
                }
                System.out.println(result);
            }

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
