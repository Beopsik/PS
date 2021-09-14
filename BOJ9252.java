import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] dp;
    static String[][] dpStr;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            String str1=st.nextToken();

            st=new StringTokenizer(br.readLine());
            String str2=st.nextToken();

            dp=new int[1001][1001];
            dpStr=new String[1001][1001];
            for(int i=0; i<=1000; i++)
                Arrays.fill(dpStr[i], "");

            int max=0;
            String maxStr="";
            for(int i=1; i<=str1.length(); i++){
                dp[i]=dp[i-1].clone();
                dpStr[i]=dpStr[i-1].clone();
                for(int j=1; j<=str2.length(); j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                        dpStr[i][j]=dpStr[i-1][j-1].concat(Character.toString(str2.charAt(j-1)));
                        if(dp[i][j]>max) {
                            max = dp[i][j];
                            maxStr=dpStr[i][j];
                        }
                    }else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
                        if(dpStr[i][j].length()<dpStr[i][j-1].length())
                            dpStr[i][j]=dpStr[i][j-1];
                    }
                }
            }

            /*System.out.print("  ");
            for(int j=1; j<=str2.length(); j++)
                System.out.print(str2.charAt(j-1)+" ");
            System.out.println();
            for(int i=1; i<=str1.length(); i++){
                System.out.print(str1.charAt(i-1)+" ");
                for(int j=1; j<=str2.length(); j++)
                    System.out.print(dp[i][j]+" ");
                System.out.println();
            }*/

            System.out.println(max);
            System.out.println(maxStr);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
