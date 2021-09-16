import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    private int weight;
    private int value;

    public Pair(int weight, int value){
        this.weight=weight;
        this.value=value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.weight-o.getWeight();
    }

    @Override
    public String toString() {
        return "Pair{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k;
    static ArrayList<Pair> item;
    static long[][] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());

            dp=new long[101][100001];
            item=new ArrayList<>();

            item.add(new Pair(0, 0));
            for(int i=1; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                item.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(item);

            for(int i=1; i<=n; i++){
                dp[i]=dp[i-1].clone();
                Pair curItem=item.get(i);
                for(int j=1; j<=k; j++){
                    if(j-curItem.getWeight()>=0){
                        dp[i][j]=Math.max(dp[i-1][j- curItem.getWeight()]+ curItem.getValue(), dp[i][j]);
                    }
                }
            }

            System.out.println(dp[n][k]);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
