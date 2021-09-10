import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    private int value;
    private int num;

    public Pair(int value, int num){
        this.value=value;
        this.num=num;
    }

    public int getValue() {
        return value;
    }

    public int getNum() {
        return num;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, k;
    static int[][] dp;
    static Pair[] coin;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            dp=new int[10001][101];
            coin=new Pair[101];

            for(int i=0; i<=10000; i++)
                Arrays.fill(dp[i], -1);

            for(int i=1; i<=k; i++){
                st=new StringTokenizer(br.readLine());
                int temp1=Integer.parseInt(st.nextToken());
                int temp2=Integer.parseInt(st.nextToken());
                coin[i]=new Pair(temp1, temp2);
            }

            System.out.println(recur(t, 1));

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int recur(int bill, int cur){

        if(bill==0)
            return 1;
        if(cur>k)
            return 0;

        if(dp[bill][cur]!=-1)
            return dp[bill][cur];

        dp[bill][cur]=0;

        for(int i=0; i<=coin[cur].getNum(); i++){
            if(bill-coin[cur].getValue()*i>=0)
                dp[bill][cur]+=recur(bill-coin[cur].getValue()*i, cur+1);
        }

        return dp[bill][cur];
    }
}
