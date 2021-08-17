import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    long length;

    public Pair(int node, long length){
        this.node=node;
        this.length=length;
    }

    @Override
    public int compareTo(Pair p) {
        return Long.compare(this.length, p.length);
    }

    public int getNode() {
        return node;
    }

    public long getLength() {
        return length;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static long[] minLen;
    static int[] trace;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n + 1];
            for(int i=0; i<n+1; i++)
                arr[i]=new ArrayList<>();

            minLen=new long[n+1];
            Arrays.fill(minLen, Long.MAX_VALUE);

            trace=new int[1001];

            for (int i = 0; i < m; i++) {
                int tmp1, tmp2, tmpLen;
                st = new StringTokenizer(br.readLine());
                tmp1 = Integer.parseInt(st.nextToken());
                tmp2 = Integer.parseInt(st.nextToken());
                tmpLen = Integer.parseInt(st.nextToken());

                arr[tmp1].add(new Pair(tmp2, tmpLen));
                arr[tmp2].add(new Pair(tmp1, tmpLen));
            }

            bfs();
            System.out.println(n-1);
            for(int i=2; i<=n; i++){
                System.out.println(i+" "+trace[i]);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    static void bfs(){
        queue=new PriorityQueue<>();

        queue.add(new Pair(1, 0));
        minLen[1]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            if(minLen[cur.getNode()]<cur.getLength()) {
                continue;
            }

            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                if (minLen[next.getNode()]>minLen[cur.getNode()]+next.getLength()) {
                    minLen[next.getNode()]=minLen[cur.getNode()]+next.getLength();
                    trace[next.getNode()]=cur.getNode();
                    queue.add(new Pair(next.getNode(), minLen[next.getNode()]));
                }
            }
        }
    }
}
