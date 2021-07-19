import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long n;
    static long left, right, mid;
    static long min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());

        left = 0;
        right = n;
        n=(long) Math.ceil(Math.sqrt(n));
        min=n;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid > n) {
                min=Math.min(min, mid);
                right = mid-1;
            } else if (mid < n) {
                left = mid+1;
            }else{
                System.out.println(mid);
                System.exit(0);
            }
        }
        System.out.println(min);
        System.exit(0);
    }
}
