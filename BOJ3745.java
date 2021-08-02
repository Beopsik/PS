import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int left, right, mid;
    static int len=0;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            len=1;
            try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[] arr=new int[n+1];
            int[] ans=new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i]=Integer.parseInt(st.nextToken());

            ans[0]=arr[0];
            for(int i=1; i<n; i++){
                if(ans[len-1]<arr[i]){
                    ans[len]=arr[i];
                    len++;
                }else{
                    int index=check(ans, len, arr[i]);
                    ans[index]=arr[i];
                }
            }

            }catch (Exception e){
                System.exit(0);
            }
            System.out.println(len);
        }
    }
    static int check(int[] ans, int len, int target){

        int left=0;
        int right=len-1;

        while(left<right){
            mid=(left+right)/2;
            if(ans[mid]>=target)
                right=mid;
            else
                left=mid+1;
        }
        return right;
    }
}
