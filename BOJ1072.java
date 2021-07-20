import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static double x, y, z;
    static int left, right, mid;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));


        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        if(x==y) {
            System.out.println(-1);
            System.exit(0);
        }

        z=100*y/x;

        if((int)z==99){
            System.out.println(-1);
            System.exit(0);
        }

        left = 1;
        right = (int)x;
        while (left <= right) {
            mid = (left + right) / 2;
            int temp=(int)((y+mid)/(x+mid)*100);
            if (temp > (int)z) {
                right = mid - 1;
            } else if (temp <=(int)z) {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
