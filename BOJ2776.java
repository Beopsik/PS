import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, n, m;
    static ArrayList<Integer> array;
    static int left, right, mid;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++) {
            array=new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                array.add(Integer.parseInt(st.nextToken()));
            Collections.sort(array);

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                boolean next = false;
                left = 0;
                right = n - 1;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (num > array.get(mid)) {
                        left = mid + 1;
                    } else if (num < array.get(mid)) {
                        right = mid - 1;
                    } else {
                        sb.append("1\n");
                        next = true;
                        break;
                    }
                }
                if (!next)
                    sb.append("0\n");
            }
        }
        System.out.print(sb);
    }
}
