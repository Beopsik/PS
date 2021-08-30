import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, w;
    static int[] arr;
    static int[][] dp;
    static int[] changeTree={0, 2, 1};
    static int Max;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            arr=new int[t+2];

            dp=new int[t+1][w+1];

            for(int i=1; i<=t; i++){
                st = new StringTokenizer(br.readLine());
                arr[i]=Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i], -1);
            }
            dfs(1, 0, 0, 0);

            System.out.println(Max);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int treeNum, int time, int move, int fruit) {

        //System.out.println("tree:"+treeNum+" time:"+time+" move:"+move+" fruit:"+fruit);
        if(time==t){
            Max=Math.max(Max, fruit);
            return;
        }

        int nextTime=time+1;
        int nextMove;
        int nextFruit;

        nextMove=move;
        if(arr[nextTime]==treeNum)
            nextFruit=fruit+1;
        else
            nextFruit=fruit;
        if(dp[nextTime][nextMove]<nextFruit) {
            dp[nextTime][nextMove]=nextFruit;
            dfs(treeNum, nextTime, nextMove, nextFruit);
        }

        nextMove=move+1;
        if(nextMove<=w) {
            if (arr[nextTime] != treeNum)
                nextFruit = fruit + 1;
            else
                nextFruit = fruit;
            if (dp[nextTime][nextMove] < nextFruit)
                dp[nextTime][nextMove] = nextFruit;
                dfs(changeTree[treeNum], nextTime, nextMove, nextFruit);
        }
    }
}
