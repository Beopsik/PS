import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            if(n%2==0)
                System.out.println("SK");
            else
                System.out.println("CY");
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
