import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    private final int linkIs;
    private final Integer weight;
    public Pair(int linkIs, int weight){
        this.linkIs=linkIs;
        this.weight=weight;
    }

    public int getLinkIs() {
        return linkIs;
    }

    public Integer getWeight() {
        return weight;
    }
}

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;

    static int[][] island;
    static int[][] bridge;
    static boolean[][] check;
    static boolean[] visit;
    static int[] dy={1, 0, -1, 0};
    static int[] dx={0, 1, 0, -1};

    static ArrayList<Pair>[] graph;

    static int count;
    static int start, end;
    static int num;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        graph=new ArrayList[11];
        for(int i=0; i<11; i++){
            graph[i]= new ArrayList<>();
        }
        island=new int[11][11];
        bridge=new int[11][11];
        check=new boolean[11][11];
        visit=new boolean[11];
        ArrayList<Integer> list=new ArrayList<>();

        for (int i=0; i<11; i++)
            Arrays.fill(bridge[i], 100);

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                island[i][j]=Integer.parseInt(st.nextToken());
        }

        num=2;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(island[i][j]==1&&!check[i][j])
                    numbering(i, j, num++);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(island[i][j]!=0) {
                    start=island[i][j];
                    for(int t=0; t<4; t++) {
                        count=0;
                        dfsBridge(i, j, t);
                    }
                }
            }
        }

        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                if(bridge[i][j]!=100){
                    Pair p1 = new Pair(j, bridge[i][j]);
                    graph[i].add(p1);
                    Pair p2 = new Pair(i, bridge[j][i]);
                    graph[j].add(p2);
                    bridge[i][j]=100;
                    bridge[j][i]=100;
                }
            }
        }

        int result=0;
        int sum=0;
        int i1=0, i2=0;
        list.add(2);
        for(int j=0; j<7; j++){
            int Min=100;
            boolean button=false;
            for (int temp : list) {
                for (int i = 0; i < graph[temp].size(); i++) {
                    if (!visit[graph[temp].get(i).getLinkIs()] && graph[temp].get(i).getWeight() < Min) {
                        button = true;
                        i1 = temp;
                        i2 = graph[temp].get(i).getLinkIs();
                        sum = graph[temp].get(i).getWeight();
                        Min = graph[temp].get(i).getWeight();
                    }
                }
            }
            if(button) {
                visit[i1] = true;
                visit[i2] = true;
                list.add(i2);
                result += sum;
            }
            if(list.size()==num-2){
                System.out.println(result);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
    public static void numbering(int y, int x, int num){
        check[y][x]=true;
        island[y][x]=num;
        for(int i=0; i<4; i++){
            int nextY=y+dy[i];
            int nextX=x+dx[i];
            if(nextY>=0&&nextY<n&&nextX>=0&&nextX<m){
                if(island[nextY][nextX]==1&&!check[nextY][nextX]){
                    numbering(nextY, nextX, num);
                }
            }
        }
    }
    public static void dfsBridge(int y, int x, int dir){
        count++;
        int nextY=y+dy[dir];
        int nextX=x+dx[dir];
        if(nextY>=0&&nextY<n&&nextX>=0&&nextX<m){
            if(island[nextY][nextX]==0){
                dfsBridge(nextY, nextX, dir);
            }else{
                end = island[nextY][nextX];
                if(count>2&&start!=end) {
                    bridge[start][end] = Math.min(bridge[start][end], count - 1);
                    bridge[end][start] = Math.min(bridge[end][start], count - 1);
                }
            }
        }
    }
}
