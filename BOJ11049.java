import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    private int r;
    private int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int[][] dp;
    static Pair[] mat;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            dp=new int[505][505];
            mat=new Pair[505];
            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                int r=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());

                mat[i]=new Pair(r, c);
            }

            for(int i=n; i>=1; i--){
                for(int j=i+1; j<=n; j++){
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i; k<=j; k++){
                        dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+mat[i].getR()*mat[k].getC()*mat[j].getC());
                    }
                }
            }

            System.out.println(dp[1][n]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
