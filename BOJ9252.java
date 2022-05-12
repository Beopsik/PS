import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            String str1=st.nextToken();

            st=new StringTokenizer(br.readLine());
            String str2=st.nextToken();

            dp=new int[1001][1001];
            char[] traceChar = new char[1001];

            int max=0;
            int y=0;
            int x=0;
            for(int i=1; i<=str1.length(); i++){
                dp[i]=dp[i-1].clone();
                for(int j=1; j<=str2.length(); j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                        if(dp[i][j]>max) {
                            max = dp[i][j];
                            y=i;
                            x=j;
                        }
                    }else
                        dp[i][j]=Math.max(dp[i][j-1], dp[i][j]);
                }
            }
            System.out.println(max);
            if(max!=0){
                int traceValue=max;
                while (true){
                    if(dp[y][x]==traceValue){
                        traceChar[traceValue]=str1.charAt(y-1);
                        traceValue-=1;
                        y-=1;
                        x-=1;
                    }
                    if(traceValue==0)
                        break;

                    while(dp[y][x-1]==dp[y][x]){
                        if(x<=1)
                            break;
                        x--;
                    }

                    while(dp[y-1][x]==dp[y][x]){
                        if(y<=1)
                            break;
                        y--;
                    }
                }
                for(int i=1; i<=max; i++)
                    System.out.print(traceChar[i]);
                System.out.println();
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
