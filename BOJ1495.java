import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    int volume;
    int index;

    public Pair(int volume, int index){
        this.volume=volume;
        this.index=index;
    }

    public int getVolume() {
        return volume;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "volume=" + volume +
                ", index=" + index +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, s, m;
    static Queue<Pair> dp;
    static int[] arr;
    static boolean[][] check;
    static int Max=-1;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            dp=new LinkedList<>();
            arr=new int[n+2];
            check=new boolean[1001][101];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                arr[i]=Integer.parseInt(st.nextToken());

            dp.add(new Pair(s, 0));
            bfs();

            if(Max==-1)
                System.out.println(-1);
            else
                System.out.println(Max);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void bfs(){

        while(!dp.isEmpty()){
            Pair cur=dp.poll();
            //System.out.println(cur.toString());

            int nextIndex=cur.getIndex()+1;

            if(nextIndex>n){
                Max=Math.max(Max, cur.getVolume());
                continue;
            }

            if(cur.getVolume()+arr[nextIndex]<=m&&!check[cur.getVolume()+arr[nextIndex]][nextIndex]) {
                check[cur.getVolume()+arr[nextIndex]][nextIndex]=true;
                dp.add(new Pair(cur.getVolume() + arr[nextIndex], nextIndex));
            }
            if(cur.getVolume()-arr[nextIndex]>=0&&!check[cur.getVolume()-arr[nextIndex]][nextIndex]) {
                check[cur.getVolume()-arr[nextIndex]][nextIndex]=true;
                dp.add(new Pair(cur.getVolume() - arr[nextIndex], nextIndex));
            }
        }
    }
}
