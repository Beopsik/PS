import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] dp;
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] check;
    static boolean[] earlyAdaptor;
    static int result=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            graph=new ArrayList[n+1];
            check=new boolean[n+1];
            earlyAdaptor=new boolean[n+1];
            dp=new int[n+1];

            for(int i=0; i<=n; i++)
                graph[i]=new ArrayList<>();

            for(int i=1; i<=n-1; i++){
                int u, v;

                st=new StringTokenizer(br.readLine());
                u=Integer.parseInt(st.nextToken());
                v=Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            Arrays.fill(dp, 1);
            dfs(1);

            System.out.println(result);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int node){

        check[node]=true;

        for(int i=0; i<graph[node].size(); i++){
            int nextNode=graph[node].get(i);

            if(!check[nextNode]) {
                if(dfs(nextNode)==1&&!earlyAdaptor[node]){
                    earlyAdaptor[node]=true;
                    result++;
                    dp[node]++;
                }
            }
        }

        return dp[node];
    }
}
