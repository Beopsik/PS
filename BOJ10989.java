import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int[] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            sb=new StringBuilder();

            dp=new int[10001];

            int num;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                num=Integer.parseInt(st.nextToken());
                dp[num]++;
            }

            for(int i=1; i<10001; i++){
                if(dp[i]==0)
                    continue;
                for(int j=0; j<dp[i]; j++)
                    sb.append(i).append("\n");
            }

            System.out.println(sb);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
