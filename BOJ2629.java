import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static ArrayList<Integer> weight;
    static boolean[][] dp;
    static ArrayList<Integer> bead;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            weight=new ArrayList<>();
            dp=new boolean[40001][91];
            bead=new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int temp;
            for(int i=0; i<n; i++) {
                temp=Integer.parseInt(st.nextToken());
                weight.add(temp);
            }

            st = new StringTokenizer(br.readLine());
            m=Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
                bead.add(Integer.parseInt(st.nextToken()));

            dfs(0, 0, 0);

            String result="";
            for(int i=0; i<m; i++){
                if(dp[bead.get(i)][0])
                    result=result.concat("Y ");
                else
                    result=result.concat("N ");
            }
            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static void dfs(int left, int right, int idx){

//        System.out.println(left+" "+right+" "+idx);

        for(int i=idx; i<n; i++){
            int curWeight=weight.get(i);
            int diff;
            diff=Math.abs(left-(right + curWeight));
            if(!dp[diff][i]) {
                dp[diff][i]=true;
                dp[diff][0]=true;
                dfs(left, right + curWeight, i + 1);
            }
            diff=Math.abs((left+curWeight)-right);
            if(!dp[diff][i+30]) {
                dp[diff][i+30]=true;
                dp[diff][0] = true;
                dfs(left + curWeight, right, i + 1);
            }
            diff=Math.abs(left-right);
            if(!dp[diff][i+60]) {
                dp[diff][i+60]=true;
                dp[diff][0] = true;
                dfs(left, right, i + 1);
            }
        }
    }
}
