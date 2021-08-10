import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int y, x;
    int weight;

    public Pair(int y, int x, int weight){
        this.y=y;
        this.x=x;
        this.weight=weight;
    }

    @Override
    public int compareTo(Pair p) {
        return Long.compare(this.weight, p.weight);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getWeight() {
        return weight;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static int[][] ans;
    static int[] dy={1, -1, 0, 0};
    static int[] dx={0, 0, 1, -1};
    static PriorityQueue<Pair> queue;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        int count=0;
        while (true){
            try{
                count++;

                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                if(n==0)
                    System.exit(0);

                arr=new int[n+1][n+1];

                ans=new int[n+1][n+1];
                for(int i=0; i<n+1; i++)
                    Arrays.fill(ans[i], Integer.MAX_VALUE);

                for(int i=0; i<n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j=0; j<n; j++) {
                        arr[i][j]=Integer.parseInt(st.nextToken());
                    }
                }

                bfs();
                System.out.println("Problem "+count+": "+ans[n-1][n-1]);

            }catch (Exception e){
                System.exit(0);
            }
        }
    }
    static void bfs(){
        queue=new PriorityQueue<>();

        queue.add(new Pair(0, 0, arr[0][0]));
        ans[0][0]=arr[0][0];

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<4; i++){
                if(cur.getY()+dy[i]>=0&&cur.getY()+dy[i]<n&&cur.getX()+dx[i]>=0&&cur.getX()+dx[i]<n){
                    int nextY=cur.getY()+dy[i];
                    int nextX=cur.getX()+dx[i];
                    int nextWeight= cur.getWeight()+arr[cur.getY()+dy[i]][cur.getX()+dx[i]];

                    if(ans[nextY][nextX]>nextWeight){
                        ans[nextY][nextX]=nextWeight;
                        queue.add(new Pair(nextY, nextX, nextWeight));
                    }
                }
            }

        }
    }
}
