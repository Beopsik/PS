import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int weight;
    int height;

    public Pair(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.getWeight()>p.getWeight()&&this.getHeight()>p.getHeight()){
            return 1;
        }else if(this.getWeight()<p.getWeight()&&this.getHeight()<p.getHeight()){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Pair temp= (Pair) obj;
        return this.getWeight() == temp.getWeight() && this.getHeight() == temp.getHeight();
    }

    @Override
    public String toString() {
        return "Pair{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, x, y;
    static ArrayList<Pair> people;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            sb=new StringBuilder();

            people=new ArrayList<>();

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                x=Integer.parseInt(st.nextToken());
                y=Integer.parseInt(st.nextToken());
                people.add(new Pair(x, y));
            }

            int[] rankList=new int[n+1];
            for(int i=0; i<people.size(); i++){
                int rank=1;
                for(int j=0; j<people.size(); j++){
                    if(j==i)
                        continue;
                    if(people.get(i).compareTo(people.get(j))==-1){
                        rank++;
                    }
                }
                rankList[i]=rank;
            }

            for(int i=0; i<n; i++){
                System.out.print(rankList[i]+" ");
            }

        }catch (Exception e){
            System.exit(0);
        }
    }
}
