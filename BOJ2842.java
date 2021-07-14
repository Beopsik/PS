import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;

    static int[][] degree;
    static char[][] board;
    static boolean[][] check;
    static Vector<Integer> height;
    static int left;
    static int right;
    static int startY;
    static int startX;
    static int numK=0;
    static int countK=0;
    static int[] dy={1, 0, -1, 0, -1, -1, 1, 1};
    static int[] dx={0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());

        degree=new int[n+1][n+1];
        board=new char[n+1][n+1];
        check=new boolean[n+1][n+1];
        height=new Vector<>();

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            board[i]=st.nextToken().toCharArray();
        }
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(board[i][j]=='P'){
                    startY=i;
                    startX=j;
                }else if(board[i][j]=='K')
                    numK++;
            }
        }
        for (int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                degree[i][j]=Integer.parseInt(st.nextToken());
                if(!height.contains(degree[i][j])){
                    height.add(degree[i][j]);
                }
            }
        }
        br.close();

        Collections.sort(height);
        left=0;
        right=0;
        int result=1000001;
        while(right<height.size()){
            while (true){
                if(left>=height.size())
                    break;
                if(degree[startY][startX]<height.get(left)||degree[startY][startX]>height.get(right))
                    break;

                countK=0;
                for(int i=0; i<n; i++)
                    Arrays.fill(check[i], false);
                if(dfs(startY, startX)){
                    result=Math.min(height.get(right)-height.get(left), result);
                    left++;
                }else{
                    break;
                }
            }
            right++;
        }
        System.out.println(result);
    }
    public static boolean dfs(int y, int x){
        check[y][x]=true;

        if(board[y][x]=='K')
            countK++;

        if(countK==numK) {
            return true;
        }

        for(int i=0; i<8; i++){
            int nextY=y+dy[i];
            int nextX=x+dx[i];
            if(nextY>=0&&nextY<n&&nextX>=0&&nextX<n){
                if(degree[nextY][nextX]>=height.get(left)&&degree[nextY][nextX]<=height.get(right)&&!check[nextY][nextX]){
                    if(dfs(nextY, nextX)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
