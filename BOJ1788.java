import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static long[] fiboPlus;
    static long[] fiboMinus;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        fiboPlus=new long[1000001];
        fiboMinus=new long[1000001];

        fiboPlus[0]=0;
        fiboPlus[1]=1;
        Plus();

        fiboMinus[1]=1;
        fiboMinus[2]=-1;
        Minus();

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n<0){
                if(fiboMinus[-n]>0){
                    System.out.println(1);
                    System.out.println(Math.abs(fiboMinus[-n]));
                }else if(fiboMinus[-n]==0){
                    System.out.println(0);
                    System.out.println(Math.abs(fiboMinus[-n]));
                }else {
                    System.out.println(-1);
                    System.out.println(Math.abs(fiboMinus[-n]));
                }
            }else{
                if(fiboPlus[n]==0){
                    System.out.println(0);
                    System.out.println(Math.abs(fiboPlus[n]));
                }else{
                    System.out.println(1);
                    System.out.println(Math.abs(fiboPlus[n]));
                }
            }
        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void Plus(){
        for(int i=2; i<=1000000; i++)
            fiboPlus[i]=(fiboPlus[i-1]+fiboPlus[i-2])%1000000000;
    }

    public static void Minus(){
        for(int i=3; i<=1000000; i++)
            fiboMinus[i]=(fiboMinus[i-2]-fiboMinus[i-1])%1000000000;
    }
}
