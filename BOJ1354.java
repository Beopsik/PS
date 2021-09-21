import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long n, p, q, x, y;
    static Map<Long, Long> map;
    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        try{
            st=new StringTokenizer(br.readLine());
            n=Long.parseLong(st.nextToken());
            p=Long.parseLong(st.nextToken());
            q=Long.parseLong(st.nextToken());
            x=Long.parseLong(st.nextToken());
            y=Long.parseLong(st.nextToken());

            map=new HashMap<>();
            System.out.println(dfs(n));

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public static long dfs(long index){
        if(map.containsKey(index))
            return map.get(index);

        if(index<=0)
            return 1;

        long result=dfs(index/p-x)+dfs(index/q-y);
        map.put(index, result);

        return result;
    }
}
