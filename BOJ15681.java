import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, r, q;
    static ArrayList<Integer>[] arrayList;
    static int[] dp;
    static boolean[] check;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            r=Integer.parseInt(st.nextToken());
            q=Integer.parseInt(st.nextToken());

            arrayList=new ArrayList[n+1];
            for(int i=1; i<=n; i++)
                arrayList[i]=new ArrayList<>();

            for(int i=0; i<n-1; i++){
                st=new StringTokenizer(br.readLine());
                int u, v;
                u=Integer.parseInt(st.nextToken());
                v=Integer.parseInt(st.nextToken());
                arrayList[u].add(v);
                arrayList[v].add(u);
            }

            dp=new int[n+1];
            check=new boolean[n+1];
            dfs(r);

            for(int i=1; i<=q; i++){
                st=new StringTokenizer(br.readLine());
                System.out.println(dp[Integer.parseInt(st.nextToken())]);
            }

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int dfs(int node){
        check[node]=true;
        dp[node]=1;

        for(int i=0; i<arrayList[node].size(); i++){
            int nextNode=arrayList[node].get(i);
            if(!check[nextNode])
                dp[node]+=dfs(nextNode);
        }

        return dp[node];
    }
}
