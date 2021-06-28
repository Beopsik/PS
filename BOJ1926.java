import java.util.Scanner;

public class Main {
    static int n, m;
    
    static int[][] array;
    static boolean[][] check;
    
    static int[] dy={1, -1, 0, 0};
    static int[] dx={0, 0, 1, -1};
    
    static int pictureNum=0;
    static int pictureSize=0;
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        n=sc.nextInt();
        m=sc.nextInt();
        
        array=new int[n][m];
        check=new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array[i][j]=sc.nextInt();
                if(array[i][j]==0)
                    check[i][j]=true;
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(check[i][j]==false&&array[i][j]==1){
                    pictureNum++;
                    pictureSize=Math.max(pictureSize,dfs(i, j, 1));
                }
            }
        }
        if(pictureNum==0){
            System.out.println(0);
            System.out.println(0);    
        }else{
            System.out.println(pictureNum);
            System.out.println(pictureSize);
        }
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
