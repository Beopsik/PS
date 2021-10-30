import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] scv;
    static boolean[][][][] check;
    static int Min=Integer.MAX_VALUE;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            scv=new int[4];

            check=new boolean [61][61][61][61];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                scv[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(recur(scv[1], scv[2], scv[3], 0));

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    public static int recur(int x, int y, int z, int count){
        if(x<=0&&y<=0&&z<=0)
            return count;

        if(x<0)
            x=0;
        if(y<0)
            y=0;
        if(z<0)
            z=0;

        if(check[x][y][z][count])
            return Integer.MAX_VALUE;

        check[x][y][z][count]=true;


        Min=Math.min(recur(x-1, y-3, z-9, count+1), Min);
        Min=Math.min(recur(x-1, y-9, z-3, count+1), Min);
        Min=Math.min(recur(x-3, y-1, z-9, count+1), Min);
        Min=Math.min(recur(x-3, y-9, z-1, count+1), Min);
        Min=Math.min(recur(x-9, y-1, z-3, count+1), Min);
        Min=Math.min(recur(x-9, y-3, z-1, count+1), Min);

        return Min;
    }
}
