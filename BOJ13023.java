import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    static int m;
    static int sum;
    static int diameter=0;
    static int far=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    
        n=sc.nextInt();
        m=sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] tree=new ArrayList[n+1];
        boolean[] check=new boolean[n+1];
        for(int i=0; i<n; i++){
            tree[i]=new ArrayList<Integer>();
        }
        
        for(int i=0; i<m; i++){
            int u, t;
            u=sc.nextInt();
            t=sc.nextInt();
            
            tree[u].add(t);
            tree[t].add(u);
        }
        
        for(int i=0; i<m; i++){
            if(dfs(tree, check, i, 0)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
        sc.close();
    }
    
    public static boolean dfs(ArrayList<Integer>[] tree, boolean[] check, int index, int count){
        check[index]=true;
        
        for(int i=0; i<tree[index].size(); i++){
            int next=tree[index].get(i);
            if(check[next]==false){
                if(count+1==4)
                    return true;
                if(dfs(tree, check, next, count+1))
                    return true;
            }
        }
        check[index]=false;
        return false;
    }
}
