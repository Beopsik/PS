import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k;
    static int[] sum;
    static int[][] dp;
    static boolean[][] check;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            sum=new int[50001];
            dp=new int[50001][4];
            check=new boolean[50001][4];

            for(int i=0; i<=50000; i++)
                Arrays.fill(dp[i], -1);

            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());;

            st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());

            if(k*3>=n)
                System.out.println(sum[n]);
            else
                System.out.println(recur(n,3));


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int recur(int idx, int roomCount){
        if(roomCount==0)
            return 0;

        if(check[idx][roomCount])
            return dp[idx][roomCount];

        check[idx][roomCount]=true;

        if(idx-1>=0)
            dp[idx][roomCount]=recur(idx-1, roomCount);
        if(idx-k>=0)
            dp[idx][roomCount]=Math.max(recur(idx-k, roomCount-1)+sum[idx]-sum[idx-k], dp[idx][roomCount]);

        return dp[idx][roomCount];
    }
}
