import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int left, right, mid;
    static ArrayList<Integer> array=new ArrayList<>();
    static ArrayList<Integer> enter=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            enter.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(array);

        for(int i=0; i<enter.size(); i++) {
            boolean next=false;
            int num=enter.get(i);
            left = 0;
            right = n-1;
            while (left <= right) {
                mid = (left + right) / 2;
                if(num>array.get(mid)){
                    left=mid+1;
                }else if(num<array.get(mid)){
                    right=mid-1;
                }else{
                    System.out.println(1);
                    next=true;
                    break;
                }
            }
            if(!next)
                System.out.println(0);
        }
    }
}
