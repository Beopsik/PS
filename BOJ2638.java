import java.util.Scanner;

public class Main {
    static int n, m;

    static int[][] array;
    static boolean[][] checkOut;
    static int[][] checkC;
    static int outCount;

    static int[] dy={1, -1, 0, 0};
    static int[] dx={0, 0, 1, -1};

    public static void main(String[] args) {
        int time=0;
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();

        array=new int[n+1][m+1];
        checkC=new int[n+1][m+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                array[i][j]=sc.nextInt();
        }
        while(true){
            outCount=0;
            checkOut=new boolean[n+1][m+1];
            dfsOut(0, 0);
            C(n, m);
            if(outCount==n*m)
                break;
            time++;
        }
        System.out.println(time);
    }
    public static void C(int n, int m){
        boolean[][] check=new boolean[n+1][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j]==1&&!check[i][j]){
                    dfsC(i, j, check);
                }
            }
        }
    }
    public static void dfsC(int y, int x, boolean[][] check){
        check[y][x]=true;

        int count=0;
        for(int t=0; t<4; t++){
            if(y+dy[t]>=0&&y+dy[t]<n&&x+dx[t]>=0&&x+dx[t]<m){
                if(checkOut[y + dy[t]][x + dx[t]])
                    count++;
                if(count>=2) {
                    array[y][x]=0;
                    checkC[y][x]=0;
                }
                if(array[y+dy[t]][x+dx[t]]==1&& !check[y + dy[t]][x + dx[t]]){
                    dfsC(y+dy[t], x+dx[t], check);
                }
            }
        }
    }
    public static void dfsOut(int y, int x){

        checkOut[y][x]=true;
        outCount++;
        for(int t=0; t<4; t++){
            if(y+dy[t]>=0&&y+dy[t]<n&&x+dx[t]>=0&&x+dx[t]<m){
                if(array[y+dy[t]][x+dx[t]]==0&&!checkOut[y + dy[t]][x + dx[t]]){
                    dfsOut(y+dy[t], x+dx[t]);
                }
            }
        }
    }
}
