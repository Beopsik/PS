import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, t;
    static int[] closet;
    static int[] open;
    static int[] dp;
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            dp=new int[n+1];

            open=new int[3];
            st = new StringTokenizer(br.readLine());
            open[1]=Integer.parseInt(st.nextToken());
            open[2]=Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            t= Integer.parseInt(st.nextToken());
            closet=new int[t+1];
            for(int i=1; i<=t; i++){
                st=new StringTokenizer(br.readLine());
                closet[i]=Integer.parseInt(st.nextToken());
            }

            dfs(1,0, open.clone());

            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static void dfs(int cIdx, int move, int[] open){

        if(cIdx==t+1){
            result=Math.min(result, move);
            return;
        }

        for(int i=1; i<=2; i++){
            int temp=open[i];
            int nextMove=move+Math.abs(open[i]-closet[cIdx]);
            open[i]=closet[cIdx];
            dfs(cIdx+1, nextMove, open.clone());
            open[i]=temp;
        }
    }
}
