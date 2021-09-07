import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    private int num;
    private int count;

    public Node(int num, int count){
        this.num=num;
        this.count=count;
    }

    public int getNum() {
        return num;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", count=" + count +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp;
    static int[] trace;
    static int result;
    static ArrayList<Integer> arrayList;
    static Queue<Node> queue;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            dp=new int[1000001];
            Arrays.fill(dp, Integer.MAX_VALUE);

            trace=new int[1000001];

            bfs();
            arrayList=new ArrayList<>();
            int temp=1;
            while(temp!=n){
                arrayList.add(temp);
                temp=trace[temp];
            }
            arrayList.add(temp);

            System.out.println(result);
            for(int i=arrayList.size()-1; i>=0; i--)
                System.out.print(arrayList.get(i)+" ");
            System.out.println();


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void bfs(){
        queue=new LinkedList<>();

        queue.add(new Node(n, 0));
        dp[n]=0;

        while(!queue.isEmpty()){
            Node cur=queue.poll();
            int curNum=cur.getNum();
            int curCount=cur.getCount();

            if(curNum==1){
                result=curCount;
                break;
            }
            int nextNum;
            int nextCount=curCount+1;

            if(curNum%3==0){
                nextNum=curNum/3;
                if(dp[nextNum]>nextCount) {
                    dp[nextNum]=nextCount;
                    queue.add(new Node(nextNum, nextCount));
                    trace[nextNum]=curNum;
                }
            }
            if(curNum%2==0){
                nextNum=curNum/2;
                if(dp[nextNum]>nextCount) {
                    dp[nextNum]=nextCount;
                    queue.add(new Node(nextNum, nextCount));
                    trace[nextNum]=curNum;
                }
            }
            nextNum=curNum-1;
            if(nextNum>=1&&dp[nextNum]>nextCount) {
                dp[nextNum]=nextCount;
                queue.add(new Node(nextNum, nextCount));
                trace[nextNum]=curNum;
            }
        }
    }
}
