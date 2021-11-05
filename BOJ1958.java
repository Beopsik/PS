import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            String str1=st.nextToken();

            st=new StringTokenizer(br.readLine());
            String str2=st.nextToken();

            st=new StringTokenizer(br.readLine());
            String str3=st.nextToken();


            int result=LCS(str1, str2, str3);
            System.out.println(result);



        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int LCS(String str1, String str2, String str3){

        dp=new int[101][101][101];

        int max=0;

        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++)
                dp[i][j]=dp[i-1][j].clone();

            for(int j=1; j<=str2.length(); j++){
                for(int t=1; t<=str3.length(); t++){
                    if(dp[i][j][t]<dp[i][j-1][t])
                        dp[i][j][t]=dp[i][j-1][t];
                }

                for(int t=1; t<=str3.length(); t++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)&&str2.charAt(j-1)==str3.charAt(t-1)){
                        dp[i][j][t]=dp[i-1][j-1][t-1]+1;
                        if(dp[i][j][t]>max) {
                            max = dp[i][j][t];
                        }
                    }else {
                        dp[i][j][t] = Math.max(dp[i][j][t-1], dp[i][j][t]);
                    }
                }
            }
        }
//        for(int i=1; i<=str1.length(); i++){
//            for(int j=1; j<=str2.length(); j++){
//                for(int t=1; t<str3.length(); t++){
//                    System.out.print(dp[i][j][t]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        return max;
    }
}
