import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[] arr;
    static int[] sum;
    static int[][] section;
    static boolean[][] check;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr=new int[102];
            sum=new int[102];
            section=new int[102][102];
            check=new boolean[102][102];

            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i]=Integer.parseInt(st.nextToken());
                sum[i]=sum[i-1]+arr[i];
            }

            System.out.println(divideSection(n, m));


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int divideSection(int k, int cnt){
        if(cnt==0)
            return 0;
        if(k<=0)
            return -1000000000;

        if(check[k][cnt])
            return section[k][cnt];

        check[k][cnt]=true;

        section[k][cnt]=divideSection(k-1, cnt);
        for(int i=1; i<=k; i++){
            section[k][cnt]=Math.max(divideSection(i-2, cnt-1)+sum[k]-sum[i-1], section[k][cnt]);
        }

        return section[k][cnt];
    }
}
