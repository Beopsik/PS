import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    long weight;

    public Pair(int node, long weight){
        this.node=node;
        this.weight=weight;
    }

    @Override
    public int compareTo(Pair p) {
        return Long.compare(this.weight, p.weight);
    }

    public int getNode() {
        return node;
    }

    public long getWeight() {
        return weight;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, e, v1, v2;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    public static void main(String[] args) {
        long[] minLen1;
        long[] minLen2;

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            arr=new ArrayList[n+1];
            for (int i=1; i<n+1; i++){
                arr[i]=new ArrayList<>();
            }
            minLen1=new long[n+1];
            Arrays.fill(minLen1, Long.MAX_VALUE);
            minLen2=new long[n+1];
            Arrays.fill(minLen2, Long.MAX_VALUE);

            for(int i=0; i<e; i++) {
                int tmp1, tmp2, tmp3;
                st = new StringTokenizer(br.readLine());
                tmp1=Integer.parseInt(st.nextToken());
                tmp2=Integer.parseInt(st.nextToken());
                tmp3=Integer.parseInt(st.nextToken());
                arr[tmp1].add(new Pair(tmp2, tmp3));
                arr[tmp2].add(new Pair(tmp1, tmp3));
            }

            st = new StringTokenizer(br.readLine());
            v1=Integer.parseInt(st.nextToken());
            v2=Integer.parseInt(st.nextToken());

            bfs(v1, minLen1);
            bfs(v2, minLen2);

            if(minLen1[1]==Long.MAX_VALUE||minLen2[1]==Long.MAX_VALUE
                    ||minLen1[n]==Long.MAX_VALUE||minLen2[n]==Long.MAX_VALUE
                    ||minLen1[v2]==Long.MAX_VALUE||minLen2[v1]==Long.MAX_VALUE) {
                System.out.println(-1);
                System.exit(0);
            }

            long result=0;
            if(minLen1[1]+minLen2[n]>minLen1[n]+minLen2[1]) {
                result += minLen2[1];
                result+=minLen1[n];
            }else {
                result += minLen1[1];
                result +=minLen2[n];
            }
            result+=minLen1[v2];

            System.out.println(result);

        }catch (Exception e){
            System.exit(0);
        }
    }
    static void bfs(int start, long[] minLen){
        queue=new PriorityQueue<>();

        queue.add(new Pair(start, 0));
        minLen[start]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                if (minLen[next.getNode()]>minLen[cur.getNode()]+next.getWeight()) {
                    minLen[next.getNode()]=minLen[cur.getNode()]+next.getWeight();
                    queue.add(new Pair(next.getNode(), minLen[next.getNode()]));
                }
            }
        }
    }
}
