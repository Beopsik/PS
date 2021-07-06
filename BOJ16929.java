import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m;

    static String[] array;
    static boolean[][] check;
    static int[] dy={1, 0, -1, 0};
    static int[] dx={0, 1, 0, -1};
    static int startY, startX;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();

        array=new String[n+1];
        check=new boolean[n+1][m+1];

        for(int i=0; i<n; i++){
                array[i]=sc.nextLine();
        }

        ArrayList<Character> colorList=new ArrayList<>();
        char color = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(color!=array[i].charAt(j)){
                    color=array[i].charAt(j);
                    if(!colorList.contains(color))
                        colorList.add(color);
                }
            }
        }

        for(int i=0; i<colorList.size(); i++){
            color=colorList.get(i);
            for(int j=0; j<n; j++){
                for(int t=0; t<m; t++){
                    if(color==array[j].charAt(t)&&!check[j][t]){
                        startY=j;
                        startX=t;
                        dfs(j, t, true, color, 0);
                    }
                }
            }
        }
        System.out.println("No");
    }
    public static void dfs(int y, int x, boolean finish, char color, int count){
        check[y][x]=true;

        for(int i=0; i<4; i++){
            if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m){
                if(array[y+dy[i]].charAt(x+dx[i])==color&&!check[y + dy[i]][x + dx[i]]){
                    finish=false;
                    dfs(y+dy[i],x+dx[i], true, color, count+1);
                }
            }
        }
        check[y][x]=false;
        if(finish&&count>=3){
            for(int i=0; i<4; i++){
                if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m){
                    if(y+dy[i]==startY&&x+dx[i]==startX){
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
