import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        try{
            arr=new int[2001];
            dp=new int[2001][2001];

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i][i]=1;
                if(arr[i-1]==arr[i])
                    dp[i-1][i]=1;
            }

            for(int i=3; i<=n; i++){
                for(int j=1; j<=n-i+1; j++){
                    int left=j;
                    int right=j+i-1;
                    if (arr[left] == arr[right]) {
                        if (dp[left + 1][right - 1] == 1)
                            dp[left][right] = 1;
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            int s, e;
            for(int i=1; i<=m; i++){
                st = new StringTokenizer(br.readLine());
                s=Integer.parseInt(st.nextToken());
                e=Integer.parseInt(st.nextToken());

                sb.append(dp[s][e]).append("\n");
            }
            System.out.println(sb);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
