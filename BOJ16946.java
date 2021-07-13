import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;

    static int[][] map;
    static boolean[][] check;
    static int[][] empty;
    static int[] group;

    static int count;
    static int numbering=1;

    static int[] dy={1, 0, -1, 0};
    static int[] dx={0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n+1][m+1];
        check=new boolean[n+1][m+1];
        empty=new int[n+1][m+1];
        group=new int[n*m+1];

        for(int i=0; i<n; i++) {
            String str=br.readLine();
            for(int j=0; j<m; j++)
                map[i][j] = str.charAt(j)-'0';
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0&&!check[i][j]) {
                    count=0;
                    dfs(i, j);
                    group[numbering++]=count;
                }
            }
        }

        sb=new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1) {
                    Set<Integer> set=new HashSet<>();
                    for (int t = 0; t < 4; t++) {
                        int nextY=i+dy[t];
                        int nextX=j+dx[t];
                        if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                            if(empty[nextY][nextX]!=0)
                                set.add(empty[nextY][nextX]);
                        }
                    }
                    int sum=1;
                    for (Integer integer : set) sum += group[integer];
                    sb.append(String.valueOf(sum%10));
                }else
                    sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int y, int x){
        check[y][x]=true;
        empty[y][x]=numbering;
        count++;
        for(int i=0; i<4; i++){
            int nextY=y+dy[i];
            int nextX=x+dx[i];
            if(nextY>=0&&nextY<n&&nextX>=0&&nextX<m){
                if(map[nextY][nextX]==0&&!check[nextY][nextX]){
                    dfs(nextY,nextX);
                }
            }
        }
    }
}
