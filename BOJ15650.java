import java.util.*;

public class Main {

    static int[] array;
    static int[] result;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        array=new int[n];
        result=new int[n];

        for(int i=0; i<n; i++){
                array[i]=i+1;
        }
        dfs(0, 0);
    }
    public static void dfs(int idx, int cnt){
        if(cnt==m){
            for (int i=0; i<m; i++)
                System.out.print(result[i]+" ");
            System.out.println();
            return;
        }
        for(int i=idx; i<n; i++){
            result[cnt]=i+1;
            dfs(i+1, cnt+1);
        }
    }
}
