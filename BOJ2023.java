import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    
        n=sc.nextInt();
        dfs(n, 0, "0");
        sc.close();
    }
    public static boolean isPrime(int num){
        if(num<2)
            return false;
        
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    public static void dfs(int n, int position, String s){
        
        if(n==position){
            System.out.println(s);
            return;
        }
        for(int i=1; i<=9; i++){
            int next=Integer.parseInt(s);
            next=next*10+i;
            if(isPrime(next)){
                dfs(n,position+1, Integer.toString(next));
            }
        }
    }
    
}
