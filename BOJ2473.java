import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long n;
    static ArrayList<Long> arr=new ArrayList<>();
    static int p1, p2, p3;
    static long Min=Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(arr);

        binarySearch();
        System.out.println(arr.get(p1)+" "+arr.get(p2)+" "+arr.get(p3));
    }
    static void binarySearch(){
        int left, mid, right;
        long sum;
        long temp;

        if(arr.get(0)<0&&arr.get(arr.size()-1)<0){
            right=arr.size()-1;
            System.out.println(arr.get(right-2)+" "+arr.get(right-1)+" "+arr.get(right));
            System.exit(0);
        }else if(arr.get(0)>0&&arr.get(arr.size()-1)>0){
            left=0;
            System.out.println(arr.get(left)+" "+arr.get(left+1)+" "+arr.get(left+2));
            System.exit(0);
        }else {
            for(int i=1; i<arr.size()-1; i++) {
                mid=i;
                left=0;
                right=arr.size()-1;
                while (left < mid && mid < right) {
                    sum= arr.get(left)+arr.get(right);
                    temp=Min;
                    Min=Math.min(Min, Math.abs(-arr.get(mid)-sum));
                    if(Min!=temp){
                        p1=left;
                        p2=mid;
                        p3=right;
                    }
                    if(sum<-arr.get(mid)){
                        left++;
                    }else if(sum>-arr.get(mid)){
                        right--;
                    }else if(sum==-arr.get(mid)){
                        System.out.println(arr.get(left)+" "+arr.get(mid)+" "+arr.get(right));
                        System.exit(0);
                    }
                }
            }
        }
    }
}
