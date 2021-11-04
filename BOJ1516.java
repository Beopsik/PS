import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;
    static int[] time;
    static ArrayList<Integer>[] order;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            order=new ArrayList[n+1];
            for (int i = 1; i <= n; i++)
                order[i] = new ArrayList<>();

            dp=new int[n+1];
            Arrays.fill(dp, -1);
            time=new int[n+1];
            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                time[i]=Integer.parseInt(st.nextToken());
                while(true){
                    int temp=Integer.parseInt(st.nextToken());
                    if(temp==-1)
                        break;
                    order[i].add(temp);
                }
            }
            for(int i=1; i<=n; i++){
                if(dp[i]==-1)
                    dfs(i);
            }

            for(int i=1; i<=n; i++)
                System.out.println(dp[i]);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int index){
        if(dp[index]!=-1)
            return dp[index];

        dp[index]=time[index];

        for(int i=0; i<order[index].size(); i++){
            int preOrder=order[index].get(i);
            dp[index]=Math.max(time[index]+dfs(preOrder), dp[index]);
        }

        return dp[index];
    }
}
