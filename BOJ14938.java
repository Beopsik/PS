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
    static int n, m ,r;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static long[] minLen;
    static int[] itemNum;
    static int Max=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = new ArrayList<>();
            }

            minLen = new long[n + 1];

            itemNum=new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                itemNum[i] = Integer.parseInt(st.nextToken());


            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                int tmp1, tmp2, tmpLen;

                tmp1 = Integer.parseInt(st.nextToken());
                tmp2 = Integer.parseInt(st.nextToken());
                tmpLen = Integer.parseInt(st.nextToken());

                arr[tmp1].add(new Pair(tmp2, tmpLen));
                arr[tmp2].add(new Pair(tmp1, tmpLen));
            }
            for(int i=1; i<=n; i++) {
                Arrays.fill(minLen, Long.MAX_VALUE);
                Max=Math.max(bfs(i), Max);
            }
            System.out.println(Max);
        }catch (Exception e){
            System.exit(0);
        }
    }
    static int bfs(int start){
        queue=new PriorityQueue<>();
        int result=0;

        queue.add(new Pair(start, 0));
        minLen[start]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                if (minLen[next.getNode()]>minLen[cur.getNode()]+next.getLength()) {
                    minLen[next.getNode()]=minLen[cur.getNode()]+next.getLength();
                    queue.add(new Pair(next.getNode(), minLen[next.getNode()]));
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(minLen[i]<=m)
                result+=itemNum[i];
        }

        return result;
    }
}
