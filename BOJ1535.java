import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dp1;
    static int[] dp2;
    static int Max;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        dp1=new int[21];
        dp2=new int[21];
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                dp1[i]=Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                dp2[i]=Integer.parseInt(st.nextToken());
            dfs(1, 0, 100);

            System.out.println(Max);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int index, int sum, int hp){
        //System.out.println("index:"+index+" sum:"+sum+" hp:"+hp);

        if(hp<=0) {
            return;
        }

        if(index>n) {
            Max=Math.max(Max, sum);
            return;
        }

        dfs(index+1, sum+dp2[index], hp-dp1[index]);
        dfs(index+1, sum, hp);
    }
}
