import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    int weight;

    public Pair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(this.weight, p.weight);
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int v, e, k;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static int[] minLen;
    static boolean[] check;
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            sb=new StringBuilder();

            arr=new ArrayList[v+1];
            for (int i=1; i<v+1; i++){
                arr[i]=new ArrayList<>();
            }
            minLen=new int[v+1];
            Arrays.fill(minLen, Integer.MAX_VALUE);

            check=new boolean[v+1];

            for(int i=0; i<e; i++) {
                int tmp1, tmp2, tmp3;
                st = new StringTokenizer(br.readLine());
                tmp1=Integer.parseInt(st.nextToken());
                tmp2=Integer.parseInt(st.nextToken());
                tmp3=Integer.parseInt(st.nextToken());
                arr[tmp1].add(new Pair(tmp2, tmp3));
            }
            if(v==1){
                System.out.println(0);
                System.exit(0);
            }

            bfs(k);

            for(int i=1; i<v+1; i++) {
                if(minLen[i]!=Integer.MAX_VALUE)
                    sb.append(minLen[i]).append("\n");
                else
                    sb.append("INF\n");
            }

            System.out.println(sb);

        }catch (Exception e){
            System.exit(0);
        }
    }
    static void bfs(int start){
        check[start]=true;
        queue=new PriorityQueue<>();

        queue.add(new Pair(start, 0));
        minLen[start]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                if (!check[next.getNode()]&&minLen[next.getNode()]>minLen[cur.getNode()]+next.getWeight()) {
                    minLen[next.getNode()]=minLen[cur.getNode()]+next.getWeight();
                    queue.add(new Pair(next.getNode(), minLen[next.getNode()]));
                }
            }
        }
    }
}
