import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[] dpMax;
    static int[] dpMin;
    static int[] input;
    static int resultMax=0;
    static int resultMin=Integer.MAX_VALUE;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            dpMax=new int[4];
            dpMin=new int[4];
            input=new int[4];

            for(int i=1; i<=n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=1; j<=3; j++)
                    input[j]=Integer.parseInt(st.nextToken());

                int tempDpMax1, tempDpMin1;
                int tempDpMax2, tempDpMin2;
                int tempDpMax3, tempDpMin3;

                tempDpMax1=Math.max(dpMax[1]+input[1], dpMax[2]+input[1]);
                tempDpMin1=Math.min(dpMin[1]+input[1], dpMin[2]+input[1]);

                tempDpMax2=Math.max(dpMax[1]+input[2], dpMax[2]+input[2]);
                tempDpMax2=Math.max(tempDpMax2, dpMax[3]+input[2]);
                tempDpMin2=Math.min(dpMin[1]+input[2], dpMin[2]+input[2]);
                tempDpMin2=Math.min(tempDpMin2, dpMin[3]+input[2]);

                tempDpMax3=Math.max(dpMax[2]+input[3], dpMax[3]+input[3]);
                tempDpMin3=Math.min(dpMin[2]+input[3], dpMin[3]+input[3]);

                dpMax[1]=tempDpMax1;
                dpMin[1]=tempDpMin1;

                dpMax[2]=tempDpMax2;
                dpMin[2]=tempDpMin2;

                dpMax[3]=tempDpMax3;
                dpMin[3]=tempDpMin3;
            }
            for(int i=1; i<=3; i++){
                resultMax=Math.max(resultMax, dpMax[i]);
                resultMin=Math.min(resultMin, dpMin[i]);
            }

            System.out.println(resultMax+" "+resultMin);

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
