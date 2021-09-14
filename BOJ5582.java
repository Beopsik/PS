import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] dp;
    static int result=0;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            dp=new int[4001][4001];

            st=new StringTokenizer(br.readLine());
            String str1=st.nextToken();

            st=new StringTokenizer(br.readLine());
            String str2=st.nextToken();

            for(int i=1; i<=str1.length(); i++){
                for(int j=1; j<=str2.length(); j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                        if(dp[i][j]>result)
                            result=dp[i][j];
                    }
                }
            }
            System.out.println(result);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
