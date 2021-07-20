import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, k;
    static ArrayList<Integer> arr=new ArrayList<>();
    static int left, right, mid;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        int result=0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(Integer.parseInt(st.nextToken()));
            sum+=arr.get(i);
        }

        left = 1;
        right = sum;
        while (left <= right) {
            mid = (left + right) / 2;
            if(check(mid)){
                result=mid;
                right=mid-1;
            }else
                left=mid+1;
        }

        System.out.println(result);
    }
    static boolean check(int mid){
        int sum=mid;
        int cnt=1;
        for(int i=0; i<arr.size(); i++){
            if(mid<arr.get(i))
                return false;

            if(sum- arr.get(i)<0){
                sum=mid;
                cnt++;
            }
            sum-=arr.get(i);
        }
        return m>=cnt;
    }
}
