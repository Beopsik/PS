import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] enter;
    static int[] dp;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            enter=new int[n+1];
            dp=new int[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                enter[i]=Integer.parseInt(st.nextToken());

            int index=1;
            dp[1]=enter[1];
            for(int i=2; i<=n; i++){
                if(dp[index]<enter[i]){
                    dp[++index]=enter[i];
                }else{
                    int temp=search(enter[i], index);
                    dp[temp]=enter[i];
                }
            }
            System.out.println(index);
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int search(int value, int right){
        int left=1;

        int result=1;
        while(left<=right){
            int mid=(left+right)/2;
            if(dp[mid]<value){
                left=mid+1;
                result=left;
            }else if(dp[mid]>value){
                right=mid-1;
            }else{
                result=mid;
                break;
            }
        }
        return result;
    }
}
