import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static String str;
    static int[] check;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        try{
            st = new StringTokenizer(br.readLine());
            str=st.nextToken();

            check=new int[10];

            check[str.charAt(0)-'0']=1;
            for(int i=1; i<str.length(); i++){
                if(str.charAt(i)-'0'==6&&check[9]<check[6]){
                    check[9]++;
                }else if(str.charAt(i)-'0'==9&&check[6]<check[9]){
                    check[6]++;
                }else
                    check[str.charAt(i)-'0']++;
            }

            int result=0;
            for(int i=0; i<10; i++)
                result=Math.max(result, check[i]);
            System.out.println(result);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
