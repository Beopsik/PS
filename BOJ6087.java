import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int y, x;
    int dy, dx;
    int weight;

    public Pair(int y, int x, int weight, int dy, int dx){
        this.y=y;
        this.x=x;
        this.weight=weight;
        this.dy=dy;
        this.dx=dx;
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

    public int getDy() {
        return dy;
    }

    public int getDx() {
        return dx;
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int w, h;
    static char[][] arr;
    static int[][] ans;
    static int[] dy={1, -1, 0, 0};
    static int[] dx={0, 0, 1, -1};
    static PriorityQueue<Pair> queue;
    static int[] cY=new int[2];
    static int[] cX=new int[2];
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr=new char[h+1][w+1];
            ans=new int[h+1][w+1];
            for(int i=0; i<h+1; i++)
                Arrays.fill(ans[i], Integer.MAX_VALUE);

            int countC=0;
            for(int i=0; i<h; i++) {
                String str= br.readLine();
                for(int j=0; j<w; j++) {
                    arr[i][j]=str.charAt(j);
                    if(arr[i][j]=='C'){
                        cY[countC]=i;
                        cX[countC]=j;
                        countC++;
                    }
                }
            }

            bfs(cY[0], cX[0]);

            System.out.println(ans[cY[1]][cX[1]]-1);
        }catch (Exception e){
            System.exit(0);
        }
    }
    static void bfs(int y, int x){
        queue=new PriorityQueue<>();

        queue.add(new Pair(y, x, 0, 0, 0));
        ans[y][x]=0;

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i=0; i<4; i++){
                if(cur.getY()+dy[i]>=0&&cur.getY()+dy[i]<h&&cur.getX()+dx[i]>=0&&cur.getX()+dx[i]<w){
                    int nextY=cur.getY()+dy[i];
                    int nextX=cur.getX()+dx[i];
                    int nextWeight;
                    if(arr[nextY][nextX]=='.'||arr[nextY][nextX]=='C') {
                        if(dy[i]==cur.getDy()&&dx[i]==cur.getDx())
                            nextWeight=cur.getWeight();
                        else
                            nextWeight=cur.getWeight()+1;
                        if (ans[nextY][nextX] >= nextWeight) {
                            ans[nextY][nextX] = nextWeight;
                            queue.add(new Pair(nextY, nextX, nextWeight, dy[i], dx[i]));
                        }
                    }
                }
            }

        }
    }
}
