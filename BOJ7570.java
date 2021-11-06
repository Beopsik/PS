import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] continuous;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            continuous=new int[n+1];

            st=new StringTokenizer(br.readLine());
            int child;
            for(int i=1; i<=n; i++){
                child=Integer.parseInt(st.nextToken());
                continuous[child]=continuous[child-1]+1;
            }

            int Max=0;
            for (int i=1; i<=n; i++) {
//                System.out.print(continuous[i] + " ");
                Max=Math.max(Max, continuous[i]);
            }

            System.out.println(n-Max);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
