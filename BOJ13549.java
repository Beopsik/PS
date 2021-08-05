import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    int second;
    int finish;

    public Pair(int node, int second, int finish){
        this.node=node;
        this.second=second;
        this.finish=finish;
    }

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(Math.abs(this.node-this.finish), Math.abs(p.node-p.finish));
    }

    public int getNode() {
        return node;
    }

    public int getSecond() {
        return second;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, k;
    static ArrayList<Pair>[] arr;
    static Deque<Pair> queue;
    static int[] minSec;
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            sb=new StringBuilder();

            arr=new ArrayList[100001];
            for (int i=0; i<100001; i++){
                arr[i]=new ArrayList<>();
            }
            minSec=new int[100001];
            Arrays.fill(minSec, Integer.MAX_VALUE);

            for(int i=0; i<100001; i++) {
                int tmp1=i-1;
                int tmp2=i+1;
                int tmp3=2*i;

                if(tmp1>=0&&tmp1<=100000)
                    arr[i].add(new Pair(tmp1, 1, k));
                if(tmp2>=0&&tmp2<=100000)
                    arr[i].add(new Pair(tmp2, 1, k));
                if(tmp3>=0&&tmp3<=100000)
                    arr[i].add(new Pair(tmp3, 0, k));
            }
            bfs(n);

            System.out.println(minSec[k]);

        }catch (Exception e){
            System.exit(0);
        }
    }
    static void bfs(int start){
        queue=new ArrayDeque<>() {};

        queue.add(new Pair(start, 0, k));
        minSec[start]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            for(int i=0; i<arr[cur.getNode()].size(); i++){
                Pair next=arr[cur.getNode()].get(i);
                if (minSec[next.getNode()]>minSec[cur.getNode()]+next.getSecond()) {
                    minSec[next.getNode()]=minSec[cur.getNode()]+next.getSecond();
                    if(next.getSecond()==0)
                        queue.addFirst(new Pair(next.getNode(), minSec[next.getNode()], k));
                    else
                        queue.addLast(new Pair(next.getNode(), minSec[next.getNode()], k));
                }
            }

        }
    }
}
