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
    static int n, m;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static int[] minLen;
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            sb=new StringBuilder();

            arr=new ArrayList[n+1];
            for (int i=1; i<n+1; i++){
                arr[i]=new ArrayList<>();
            }

            for(int i=0; i<m; i++) {
                int tmp1, tmp2, tmp3;
                st = new StringTokenizer(br.readLine());
                tmp1=Integer.parseInt(st.nextToken());
                tmp2=Integer.parseInt(st.nextToken());
                tmp3=Integer.parseInt(st.nextToken());
                arr[tmp1].add(new Pair(tmp2, tmp3));
            }

            for (int i=1; i<n+1; i++){
                arr[i].sort(Comparator.naturalOrder());
            }

            minLen=new int[n+1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(minLen, Integer.MAX_VALUE);
                bfs(i);
                for (int j = 1; j <= n; j++) {
                    if(minLen[j]==Integer.MAX_VALUE)
                        System.out.print(0+" ");
                    else
                        System.out.print(minLen[j]+" ");
                }
                System.out.println();
            }

        }catch (Exception e){
            System.exit(0);
        }
    }
    static void bfs(int start){
        queue=new PriorityQueue<>();

        queue.add(new Pair(start, 0));
        minLen[start]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next = arr[cur.getNode()].get(i);
                if (minLen[next.getNode()]>minLen[cur.getNode()]+next.getWeight()) {
                    minLen[next.getNode()]=minLen[cur.getNode()]+next.getWeight();
                    queue.add(new Pair(next.getNode(), minLen[next.getNode()]));
                }
            }
//            while(!arr[cur.getNode()].isEmpty()){
//                Pair next=arr[cur.getNode()].poll();
//                if (minLen[next.getNode()]>minLen[cur.getNode()]+next.getWeight()) {
//                    minLen[next.getNode()]=minLen[cur.getNode()]+next.getWeight();
//                    queue.add(new Pair(next.getNode(), minLen[next.getNode()]));
//                }
//            }
        }
    }
}
