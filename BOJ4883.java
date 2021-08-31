import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    long node;
    int x;
    int y;

    public Node(long node, int y, int x){
        this.node=node;
        this.y=y;
        this.x=x;
    }

    public long getNode() {
        return node;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node=" + node +
                ", y=" + y +
                ", x=" + x +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] graph;
    static long[][] dp;
    static Queue<Node> queue;
    static int[][] dx={{0, 1, 1}, {-1, 0, 1, 1}, {-1, 0}};
    static int[][] dy={{1, 1, 0}, {1,  1, 1, 0}, {1, 1}};
    static int count=1;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            while (true) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                if(n==0)
                    break;

                graph = new int[n + 1][4];
                dp = new long[n + 1][4];

                for (int i = 1; i <= n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 1; j <= 3; j++)
                        graph[i][j] = Integer.parseInt(st.nextToken());

                    Arrays.fill(dp[i], Integer.MAX_VALUE);
                }
                bfs();
                System.out.println((count++)+". "+dp[n][2]);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void bfs(){
        queue=new LinkedList<>();

        dp[1][2]=graph[1][2];

        queue.add(new Node(dp[1][2], 1, 2));

        while(!queue.isEmpty()){
            Node cur=queue.poll();

            int curY=cur.getY();
            int curX=cur.getX();
            for(int i=0; i<dx[curX-1].length; i++){
                int nextY=curY+dy[curX-1][i];
                int nextX=curX+dx[curX-1][i];
                long nextNode;
                if(nextY>=1&&nextY<=n&&nextX>=1&&nextX<=3){
                    nextNode=dp[curY][curX]+graph[nextY][nextX];
                    if(dp[nextY][nextX]>nextNode){
                        dp[nextY][nextX]=nextNode;
                        queue.add(new Node(nextNode, nextY, nextX));
                    }
                }
            }
        }
    }
}
