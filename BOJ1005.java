import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, n, k, w;
    static int[] time;
    static int[] dp;
    static ArrayList<Integer>[] order;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());

            for(int tc=0; tc<t; tc++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                time = new int[n + 1];
                dp = new int[n + 1];
                order = new ArrayList[n + 1];
                for (int i = 1; i <= n; i++)
                    order[i] = new ArrayList<>();
                Arrays.fill(dp, -1);

                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) {
                    time[i] = Integer.parseInt(st.nextToken());
                }

                for (int i = 1; i <= k; i++) {
                    int temp1, temp2;
                    st = new StringTokenizer(br.readLine());
                    temp1 = Integer.parseInt(st.nextToken());
                    temp2 = Integer.parseInt(st.nextToken());
                    order[temp2].add(temp1);
                }

                st = new StringTokenizer(br.readLine());
                w = Integer.parseInt(st.nextToken());

                System.out.println(dfs(w));
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int buildingNum){
        if(dp[buildingNum]!=-1)
            return dp[buildingNum];

        dp[buildingNum]=time[buildingNum];

        for(int i=0; i<order[buildingNum].size(); i++) {
            dp[buildingNum] = Math.max(dp[buildingNum], time[buildingNum] + dfs(order[buildingNum].get(i)));
        }

        return dp[buildingNum];
    }
}
