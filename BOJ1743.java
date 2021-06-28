import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n, m, k;
    
    static int[][] array;
    static boolean[][] check;
    
    static int[] dy={1, -1, 0, 0};
    static int[] dx={0, 0, 1, -1};
    
    static int trashSize=0;
    
    public static void main(String[] args) {
        int r, c;
        
        Scanner sc=new Scanner(System.in);
        
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        
        array=new int[n][m];
        check=new boolean[n][m];
        
        for(boolean temp[]:check)
            Arrays.fill(temp, true);
        
        for(int i=0; i<k; i++){
            r=sc.nextInt();
            c=sc.nextInt();
            array[r-1][c-1]=1;
            check[r-1][c-1]=false;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(check[i][j]==false&&array[i][j]==1){
                    trashSize=Math.max(trashSize,dfs(i, j, 1));
                }
            }
        }
        System.out.println(trashSize);
    }
    
    public static int dfs(int y, int x, int size){
        
        check[y][x]=true;
        
        for(int t=0; t<4; t++){
            if(y+dy[t]>=0&&y+dy[t]<n&&x+dx[t]>=0&&x+dx[t]<m){
                if(array[y+dy[t]][x+dx[t]]==1&&check[y+dy[t]][x+dx[t]]==false){
                    size++;
                    size=dfs(y+dy[t], x+dx[t], size);
                }
            }
        }
        return size;
    }
}
