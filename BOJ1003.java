import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, tc;
    static int[] dp0;
    static int[] dp1;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp0 = new int[41];
        dp1 = new int[41];
        dp0[0]=1;
        dp1[0]=0;
        dp0[1]=0;
        dp1[1]=1;

        try{
            st = new StringTokenizer(br.readLine());
            tc=Integer.parseInt(st.nextToken());

            int temp=-1;
            for(int i=0; i<tc; i++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                if(n>temp) {
                    for (int j = 2; j <= n; j++) {
                        dp0[j] = dp0[j - 1] + dp0[j - 2];
                        dp1[j] = dp1[j - 1] + dp1[j - 2];
                    }
                }

                System.out.println(dp0[n]+" "+dp1[n]);
                temp=n;
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
