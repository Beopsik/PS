import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    int length;

    public Pair(int node, int length){
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

    public int getLength() {
        return length;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m ,x;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static int[][] minLen;
    static int Max=0;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = new ArrayList<>();
            }

            minLen=new int[n+1][n+1];
            for(int i=0; i<n+1; i++)
                Arrays.fill(minLen[i], Integer.MAX_VALUE);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int tmp1, tmp2, tmpLen;

                tmp1 = Integer.parseInt(st.nextToken());
                tmp2 = Integer.parseInt(st.nextToken());
                tmpLen = Integer.parseInt(st.nextToken());

                arr[tmp1].add(new Pair(tmp2, tmpLen));
            }

            for (int i=1; i<=n; i++)
                bfs(i);

            for(int i=1; i<=n; i++) {
                Max=Math.max(minLen[i][x]+minLen[x][i], Max);
            }
            System.out.println(Max);
        }catch (Exception e){
            System.out.println(e.toString());
            System.exit(0);
        }
    }
    static void bfs(int start){
        queue=new PriorityQueue<>();

        queue.add(new Pair(start, 0));
        minLen[start][start]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                if (minLen[start][next.getNode()]>minLen[start][cur.getNode()]+next.getLength()) {
                    minLen[start][next.getNode()]=minLen[start][cur.getNode()]+next.getLength();
                    queue.add(new Pair(next.getNode(), minLen[start][next.getNode()]));
                }
            }
        }
    }
}
