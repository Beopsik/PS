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
    static StringBuilder sb;
    static int n, m;
    static int a, b;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> queue;
    static long[] minLen;
    static int[] trace;

    public static void main(String[] args) {

        try{
            Scanner scanner=new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();

            arr = new ArrayList[n + 1];
            for(int i=0; i<n+1; i++)
                arr[i]=new ArrayList<>();

            minLen=new long[n+1];
            Arrays.fill(minLen, Long.MAX_VALUE);

            trace=new int[1001];

            for (int i = 0; i < m; i++) {
                int tmp1, tmp2, tmpLen;

                tmp1 = scanner.nextInt();
                tmp2 = scanner.nextInt();
                tmpLen = scanner.nextInt();

                arr[tmp1].add(new Pair(tmp2, tmpLen));
            }

            a=scanner.nextInt();
            b=scanner.nextInt();

            bfs(a);

            ArrayList<Integer> result=new ArrayList<>();
            int node=b;
            int cnt=0;
            while(node!=0){
                result.add(node);
                node=trace[node];
            }
            System.out.println(minLen[b]);
            System.out.println(result.size());

            sb=new StringBuilder();
            for(int i=result.size()-1; i>=0; i--)
                sb.append(result.get(i)).append(" ");
            System.out.println(sb);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    static void bfs(int start){
        queue=new PriorityQueue<>();

        queue.add(new Pair(start, 0));
        minLen[start]=0;

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
