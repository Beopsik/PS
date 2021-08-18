import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    int time;
    int cost;

    public Pair(int node, int cost, int time){
        this.node=node;
        this.cost=cost;
        this.time=time;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.time==p.time)
            return this.cost-p.cost;
        else
            return this.time-p.time;
    }

    public int getNode() {
        return node;
    }

    public int getCost() {
        return cost;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", time=" + time +
                ", cost=" + cost +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int tc, n, m, k;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static long[][] dp;
    static long answer;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            tc = Integer.parseInt(st.nextToken());
            for(int TC=0; TC<tc; TC++) {
                answer=Long.MAX_VALUE;
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                dp=new long[n+1][m+1];
                arr = new ArrayList[n + 1];
                for (int i = 0; i < n + 1; i++) {
                    Arrays.fill(dp[i], Long.MAX_VALUE);
                    arr[i] = new ArrayList<>();
                }


                for (int i = 0; i < k; i++) {
                    int tmp1, tmp2, tmpTime, tmpCost;
                    st = new StringTokenizer(br.readLine());
                    tmp1 = Integer.parseInt(st.nextToken());
                    tmp2 = Integer.parseInt(st.nextToken());
                    tmpCost = Integer.parseInt(st.nextToken());
                    tmpTime = Integer.parseInt(st.nextToken());

                    arr[tmp1].add(new Pair(tmp2, tmpCost, tmpTime));
                }

                dp[1][0]=0;
                bfs();
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    static void bfs(){
        queue=new PriorityQueue<>();

        queue.add(new Pair(1, 0, 0));

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            System.out.println(cur.toString());
            if(cur.node==n){
                answer=Math.min(answer, cur.getTime());
                break;
            }
            
            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                
                int sumCost=cur.getCost()+next.getCost();
                if(sumCost>m)
                    continue;

                int sumTime=cur.getTime()+ next.getTime();
                if(dp[next.getNode()][sumCost]>sumTime){
                    dp[next.getNode()][sumCost]=sumTime;
                    queue.add(new Pair(next.getNode(), sumCost, sumTime));
                }
            }
        }
        if(answer==Long.MAX_VALUE)
            System.out.println("Poor KCM");
        else
            System.out.println(answer);
    }
}
