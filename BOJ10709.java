import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int h, w;
    static char[][] cloud;
    static int[][] result;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            sb= new StringBuilder();
            h=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            cloud=new char[h+1][w+1];
            result=new int[h+1][w+1];

            for(int i=0; i<h; i++)
                Arrays.fill(result[i], -1);

            for(int i=0; i<h; i++){
                String str= br.readLine();
                for(int j=0; j<w; j++) {
                    cloud[i][j]=str.charAt(j);
                    if (cloud[i][j]=='c')
                        result[i][j]=0;
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(result[i][j]==0){
                            dfs(1, i, j+1);
                    }
                }
            }

            for (int i=0; i<h; i++){
                for (int j=0; j<w; j++)
                    sb.append(result[i][j]).append(" ");
                sb.append("\n");
            }
            System.out.println(sb);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void dfs(int num, int y, int x){
        if(result[y][x]==0)
            return;
        if(x>=w)
            return;

        result[y][x]=num;
        dfs(num+1, y, x+1);
    }
}
