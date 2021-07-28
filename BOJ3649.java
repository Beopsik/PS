import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long x, n;
    static ArrayList<Long> arr=new ArrayList<>();
    static int p1, p2;
    static boolean block;

    public static void main(String[] args){
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            try {
                block = false;

                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());

                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    arr.add(Long.parseLong(st.nextToken()));
                }
                if (n <= 1)
                    System.out.println("danger");
                else {
                    Collections.sort(arr);

                    binarySearch();
                    if (block)
                        System.out.println("yes " + arr.get(p1) + " " + arr.get(p2));
                    else
                        System.out.println("danger");
                }
                if (!arr.isEmpty())
                    arr.clear();
            }catch (Exception e){
                System.exit(0);
            }
        }
    }
    static void binarySearch(){
        int left, right;
        long sum;

        left=0;
        right=arr.size()-1;
        while (left<right) {
            sum= arr.get(left)+arr.get(right);
            if(sum<x*10000000){
                left++;
            }else if(sum>x*10000000){
                right--;
            }else{
                block=true;
                p1=left;
                p2=right;
                break;
            }
        }
    }
}
