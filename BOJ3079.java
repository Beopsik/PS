import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long n, m;
    static ArrayList<Long> arr=new ArrayList<>();
    static long left, right, mid;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        long Max=0;
        long result=0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(Long.parseLong(st.nextToken()));
            Max=Math.max(Max, arr.get(i));
        }
        Collections.sort(arr);

        left = 1;
        right = Max*m;
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
    static boolean check(long mid){
        long sum=mid;
        long cnt=0;
        for(int i=0; i<arr.size(); i++){
            cnt+=mid/arr.get(i);
        }
        return m<=cnt;
    }
}
