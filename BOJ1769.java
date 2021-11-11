import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static String str;
    static int count;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        try{
            st = new StringTokenizer(br.readLine());
            str=st.nextToken();

            count=0;
            while(str.length()!=1) {
                int sum = 0;
                for (int i=0; i<str.length(); i++){
                    sum+=Integer.parseInt(Character.toString(str.charAt(i)));
                }
                count++;
                str=Integer.toString(sum);
            }

            int result=Integer.parseInt(str);
            if(result%3==0){
                System.out.println(count);
                System.out.println("YES");
            }else{
                System.out.println(count);
                System.out.println("NO");
            }


        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
