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
        long ans=0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr.add(Long.parseLong(st.nextToken()));
            Max=Math.max(Max, arr.get(i));
        }
        //Collections.sort(arr);
        if(n<=m)
            System.out.println(n);
        else {
            left = 1;
            right = Max * n;
            while (left <= right) {
                mid = (left + right) / 2;
                if (check(mid)) {
                    result = mid;
                    right = mid - 1;
                } else
                    left = mid + 1;
            }

            long cnt=m;
            for(int i=0; i<arr.size(); i++)
                cnt+=(result-1)/arr.get(i);

            for(int j=0; j<arr.size(); j++){
                if(result%arr.get(j)==0) {
                    cnt++;
                }
                if(cnt==n){
                    System.out.println(j+1);
                    System.exit(0);
                }
            }
        }
    }
    static boolean check(long mid){
        long sum=mid;
        long cnt=0;
        for(int i=0; i<arr.size(); i++){
            cnt+=mid/arr.get(i);
        }
        return (n-m)<=cnt;
    }
}
