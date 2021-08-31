import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int a;
    int b;

    public Pair(int a, int b){
        this.a=a;
        this.b=b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Pair o) {
        return this.a-o.a;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static ArrayList<Pair> pole;
    static int[] list;
    static int len=1;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            list=new int[n+2];

            pole=new ArrayList<>();
            pole.add(new Pair(0, 0)); //dummy pair for pretty index
            for(int i=1; i<=n; i++){
                int a, b;
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                pole.add(new Pair(a, b));
            }
            Collections.sort(pole);

            list[1]=pole.get(1).getB();
            for(int i=2; i<=n; i++){
                int bTemp=pole.get(i).getB();
                if(list[len]<bTemp){
                    list[++len]=bTemp;
                }else{
                    int index=binarySearch(bTemp);
                    list[index]=bTemp;
                }
            }

            System.out.println(n-len);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static int binarySearch(int target){

        int left=1;
        int right=len;
        int mid;
        int result=1;

        while(left<=right){
            mid=(left+right)/2;
            if(list[mid]>target) {
                right = mid - 1;
            }else if(list[mid]<target) {
                left = mid + 1;
                result=left;
            }else{
                result=mid;
                break;
            }
        }
        return result;
    }
}
