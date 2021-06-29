import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    static int leafNode=0;
    static int delete;
    static boolean checkDelete=false;

    public static void main(String[] args) {
        int pNode;
        int root=0;
        Scanner sc=new Scanner(System.in);
    
        n=sc.nextInt();
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] tree=new ArrayList[n+1];
        for(int i=0; i<n; i++){
            tree[i]=new ArrayList<Integer>();
        }
        
        for(int i=0; i<n; i++){
            pNode=sc.nextInt();
            
            if(pNode==-1){
                root=i;
                continue;
            }
            
            tree[pNode].add(i);
        }
        
        delete=sc.nextInt();
        
        dfs(tree, root);
        System.out.println(leafNode);
        sc.close();
    }
    
    public static void dfs(ArrayList<Integer>[] tree, int index){
        
        if(index==delete){
            checkDelete=true;
            return;
        }
        
        int childNum=tree[index].size();
        if(childNum==0){
            leafNode++;
        }else{
            for(int i=0; i<childNum; i++){
                int next=tree[index].get(i);
                dfs(tree, next);
                if(checkDelete){
                    if(childNum==1)
                        leafNode++;
                    checkDelete=false;
                }
            }
        }
    }
}
