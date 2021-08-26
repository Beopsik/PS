import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static long[] fibo;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        fibo=new long[68];

        fibo[0]=1;
        fibo[1]=1;
        fibo[2]=2;
        fibo[3]=4;

        try{
            dfs(4);
            st = new StringTokenizer(br.readLine());
            int tc=Integer.parseInt(st.nextToken());
            for(int i=0; i<tc; i++) {

                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                System.out.println(fibo[n]);
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int num){
        if(num==68)
            return;

        fibo[num]=fibo[num-1]+fibo[num-2]+fibo[num-3]+fibo[num-4];
        dfs(num+1);
    }
}
