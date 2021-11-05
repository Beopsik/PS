import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    private final int left;
    private final int right;
    private final int energy;
    private final int index;

    public Pair(int left, int right, int energy, int index) {
        this.left = left;
        this.right = right;
        this.energy = energy;
        this.index=index;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getEnergy() {
        return energy;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Pair o) {
        return this.energy-o.energy;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                ", energy=" + energy +
                ", index=" + index +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] energy={{0, 2, 2, 2, 2},
                          {0, 1, 3, 4, 3},
                          {0, 3, 1, 3, 4},
                          {0, 4, 3, 1, 3},
                          {0, 3, 4, 3, 1}};
    static int[][][] dp;
    static ArrayList<Integer> push;
    static PriorityQueue<Pair> queue;
    static int Min=Integer.MAX_VALUE;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            push=new ArrayList<>();

            while (true){
                int input=Integer.parseInt(st.nextToken());
                if(input==0)
                    break;
                push.add(input);
            }

            dp=new int[5][5][push.size()+1];
            for(int i=0; i<=4; i++){
                for (int j=0; j<=4; j++)
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }

            bfs();
            System.out.println(Min);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void bfs(){
        queue=new PriorityQueue<>();
        queue.add(new Pair(0, 0, 0, 0));
        dp[0][0][0]=0;

        while(!queue.isEmpty()){
            Pair cur=queue.poll();

            int curLeft=cur.getLeft();
            int curRight=cur.getRight();
            int curEnergy=cur.getEnergy();
            int curIdx=cur.getIndex();

            if(curIdx==push.size()) {
                Min=Math.min(Min, curEnergy);
                break;
            }

            int move=push.get(curIdx);
            if(curEnergy+energy[curLeft][move]<dp[move][curRight][curIdx+1]){
                dp[move][curRight][curIdx+1]=curEnergy+energy[curLeft][move];
                queue.add(new Pair(move, curRight, curEnergy+energy[curLeft][move], curIdx+1));
            }
            if(curEnergy+energy[curRight][move]<dp[curLeft][move][curIdx+1]){
                dp[curLeft][move][curIdx+1]=curEnergy+energy[curRight][move];
                queue.add(new Pair(curLeft, move, curEnergy+energy[curRight][move], curIdx+1));
            }
        }
    }
}
