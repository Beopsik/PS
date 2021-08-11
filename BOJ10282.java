import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    long second;

    public Pair(int node, long second){
        this.node=node;
        this.second=second;
    }

    @Override
    public int compareTo(Pair p) {
        return Long.compare(this.second, p.second);
    }

    public int getNode() {
        return node;
    }

    public long getsecond() {
        return second;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int tc, n, d, c;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static long[] minSec;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            tc = Integer.parseInt(st.nextToken());

            for(int k=0; k<tc; k++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                arr = new ArrayList[n + 1];
                for (int i = 1; i < n + 1; i++) {
                    arr[i] = new ArrayList<>();
                }
                minSec = new long[n + 1];
                Arrays.fill(minSec, Long.MAX_VALUE);

                for (int i = 0; i < d; i++) {
                    int a, b, s;
                    st = new StringTokenizer(br.readLine());
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    s = Integer.parseInt(st.nextToken());
                    arr[b].add(new Pair(a, s));
                }

                bfs(c);

                int count=0;
                long result=0;
                for(int i=1; i<n+1; i++){
                    if(minSec[i]==Long.MAX_VALUE)
                        continue;

                    if(result<minSec[i])
                        result=minSec[i];

                    count++;
                }
                System.out.println(count+" "+result);
            }
        }catch (Exception e){
            System.exit(0);
        }
    }
    static void bfs(int start){
        queue=new PriorityQueue<>();

        queue.add(new Pair(start, 0));
        minSec[start]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                if (minSec[next.getNode()]>minSec[cur.getNode()]+next.getsecond()) {
                    minSec[next.getNode()]=minSec[cur.getNode()]+next.getsecond();
                    queue.add(new Pair(next.getNode(), minSec[next.getNode()]));
                }
            }
        }
    }
}
