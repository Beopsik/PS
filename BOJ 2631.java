import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] child;
    static int[] dp;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            child=new int[n+1];
            dp=new int[n+1];

            for(int i=1; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                child[i]=Integer.parseInt(st.nextToken());
            }

            int index=1;
            dp[1]=child[1];
            for(int i=2; i<=n; i++){
                if(dp[index]<child[i]){
                    dp[++index]=child[i];
                }else{
                    int temp=binarySearch(index, child[i]);
                    dp[temp]=child[i];
                }
            }
            System.out.println(n-index);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int binarySearch(int right, int target){

        int left=1;

        int result=1;
        while(left<=right){
            int mid=(left+right)/2;
            if(dp[mid]<target){
                left=mid+1;
                result=left;
            }else if(dp[mid]>target){
                right=mid-1;
            }else{
                result=mid;
                break;
            }
        }

        return result;
    }
}
