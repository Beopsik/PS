import java.util.Scanner;

public class Main {
    static int r, c;

    static String[] array;
    static boolean[][] check;
    static boolean[][] noPath;
    static boolean[] end;

    static int[] dy={-1, 0, 1};
    static int[] dx={1, 1, 1};
    static int Max=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        sc.nextLine();

        array=new String[r+1];
        check=new boolean[r+1][c+1];
        noPath=new boolean[r+1][c+1];
        end=new boolean[r+1];

        for(int i=0; i<r; i++)
            array[i]=sc.nextLine();

        for(int i=0; i<r; i++){
            if(dfs(i, 0))
                Max++;
        }
        System.out.println(Max);
    }
    public static boolean dfs(int y, int x){
        check[y][x]=true;

        if(x==c-1){
            return true;
        }

        for(int i=0; i<3; i++){
            if(y+dy[i]>=0&&y+dy[i]<r&&x+dx[i]>=0&&x+dx[i]<c){
                if(!check[y+dy[i]][x+dx[i]]&&array[y+dy[i]].charAt(x+dx[i])=='.') {
                    if(dfs(y + dy[i], x + dx[i]))
                        return true;
                }
            }
        }
        return false;
    }
}
