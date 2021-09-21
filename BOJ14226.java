import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    private int emoNum;
    private int time;
    private int op;
    private int copyNum;

    public Pair(int emoNum, int time, int op, int copyNum){
        this.emoNum=emoNum;
        this.time=time;
        this.op=op;
        this.copyNum=copyNum;
    }

    public int getEmoNum() {
        return emoNum;
    }

    public int getTime() {
        return time;
    }

    public int getOp() {
        return op;
    }

    public int getCopyNum() {
        return copyNum;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.time==o.getTime()){
            return this.emoNum-o.getEmoNum();
        }
        return this.time-o.getTime();
    }

    @Override
    public String toString() {
        return "Pair{" +
                "emoNum=" + emoNum +
                ", time=" + time +
                ", op=" + op +
                ", copyNum=" + copyNum +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int s;
    static int[][] dp;
    static PriorityQueue<Pair> queue;
    static int Min=Integer.MAX_VALUE;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken());

            dp = new int[1001][1001];
            for (int i = 0; i <= 1000; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);

            bfs();

            Min=Integer.MAX_VALUE;
            for(int i=1; i<=1000; i++)
                Min=Math.min(Min, dp[s][i]);

            System.out.println(Min);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void bfs(){
        queue=new PriorityQueue<>();

        queue.add(new Pair(1,1,1, 1));

        while(!queue.isEmpty()){
            Pair cur=queue.poll();

            if(cur.getEmoNum()<=1000&&dp[cur.getEmoNum()][cur.getEmoNum()]==Integer.MAX_VALUE){
                dp[cur.getEmoNum()][cur.getEmoNum()]=cur.getTime()+1;
                queue.add(new Pair(cur.getEmoNum(), cur.getTime()+1, 1, cur.getEmoNum()));
            }
            if(cur.getEmoNum()+cur.getCopyNum()<=1000&&dp[cur.getEmoNum()+cur.getCopyNum()][cur.getCopyNum()]==Integer.MAX_VALUE){
                dp[cur.getEmoNum()+cur.getCopyNum()][cur.getCopyNum()]=cur.getTime()+1;
                queue.add(new Pair(cur.getEmoNum()+cur.getCopyNum(), cur.getTime()+1, 2,  cur.getCopyNum()));
            }
            if(cur.getEmoNum()-1>0&&dp[cur.getEmoNum()-1][cur.getCopyNum()]==Integer.MAX_VALUE){
                dp[cur.getEmoNum()-1][cur.getCopyNum()]=cur.getTime()+1;
                queue.add(new Pair(cur.getEmoNum()-1, cur.getTime()+1, 3,  cur.getCopyNum()));
            }
        }
    }
}
