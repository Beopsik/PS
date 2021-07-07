
import java.util.*;

public class Main {
    static int result=0;
    static int[] selected;

    static String[] array;
    static boolean[] visited;
    static boolean[] adjacented;
    static int[] dy={1, 0, -1, 0};
    static int[] dx={0, 1, 0, -1};
    static Queue<Integer> q;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        array=new String[5];
        for(int i=0; i<5; i++){
            array[i]=sc.nextLine();
        }

        visited=new boolean[5*5];
        selected=new int[7];

        dfs(0, 0, 0);
        System.out.println(result);
    }
    public static void dfs(int idx, int cnt,int cntS){
        if(cnt==7){
            if(cntS>=4){
                if(checkAdj()){
                    result++;
                    return;
                }
            }
            return;
        }
        for(int i=idx; i<5*5; i++){
            visited[i]=true;

            selected[cnt]=i;
            if(array[i/5].charAt(i%5)=='S')
                dfs(i+1, cnt+1, cntS+1);
            else
                dfs(i+1,cnt+1,cntS);

            visited[i]=false;
        }
    }
    public static boolean checkAdj(){
        int cnt=1;
        adjacented=new boolean[5*5];
        q=new LinkedList<>();
        q.add(selected[0]);

        while(!q.isEmpty()){
            int now=q.poll();
            adjacented[now]=true;

            for(int i=0; i<4; i++){
                int y=(now/5)+dy[i];
                int x=(now%5)+dx[i];
                if(y<0||x<0||y>=5||x>=5)
                    continue;
                if(adjacented[y*5+x])
                    continue;
                if(!visited[y*5+x])
                    continue;
                cnt++;
                adjacented[y*5+x]=true;
                q.add(y*5+x);
            }
        }
        if(cnt==7)
            return true;
        else
            return false;
    }
}
