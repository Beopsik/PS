import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int a, b, c;
    static int[][][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp=new int[21][21][21];
        try{
            while (true) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                if (a == -1 && b == -1 && c == -1)
                    System.exit(0);

                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int w(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20&&dp[20][20][20]!=0)
            return w(20, 20, 20);

        if(dp[a][b][c]!=0)
            return dp[a][b][c];

        if (a < b && b < c)
            return dp[a][b][c]=w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        return dp[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
