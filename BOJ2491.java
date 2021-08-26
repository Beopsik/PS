import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static int[] up;
    static int[] down;
    static int Max=1;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        arr=new int[100001];
        up=new int[100001];
        down=new int[100001];

        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            dfs(1);

            System.out.println(Max);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int index){
        if(index==n)
            return;

        dfs(index+1);

        if(arr[index]>arr[index+1]){
            down[index]+=down[index+1];
            Max=Math.max(Max, down[index]);
        }else if(arr[index]<arr[index+1]){
            up[index]+=up[index+1];
            Max=Math.max(Max, up[index]);
        }else{
            down[index]+=down[index+1];
            up[index]+=up[index+1];
            Max=Math.max(Max, down[index]);
            Max=Math.max(Max, up[index]);
        }
    }
}
