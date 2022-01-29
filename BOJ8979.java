import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Medal implements Comparable<Medal>{
    private int countryNum;
    private int gold;
    private int silver;
    private int bronze;

    public Medal(int countryNum, int gold, int silver, int bronze) {
        this.countryNum=countryNum;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public int getCountryNum() {
        return countryNum;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }

    @Override
    public int compareTo(Medal m) {
        if(this.getGold()>m.getGold()){
            return 1;
        }else if(this.getGold()==m.getGold()&&this.getSilver()>m.getSilver()){
            return 1;
        }else if(this.getGold()==m.getGold()&&this.getSilver()==m.getSilver()&&this.getBronze()>m.getBronze()){
            return 1;
        }else if(this.getGold()==m.getGold()&&this.getSilver()==m.getSilver()&&this.getBronze()==m.getBronze()){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Medal m= (Medal) obj;
        return this.getCountryNum()==m.getCountryNum()&&this.getGold()==m.getGold()&&this.getSilver()==m.getSilver()&&this.getBronze()==this.getBronze();
    }

    @Override
    public String toString() {
        return "Medal{" +
                "countryNum=" + countryNum +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                '}';
    }
}
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, k;
    static ArrayList<Medal> country;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            country=new ArrayList<>();

            int countryNum;
            int gold;
            int silver;
            int bronze;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                countryNum=Integer.parseInt(st.nextToken());
                gold=Integer.parseInt(st.nextToken());
                silver=Integer.parseInt(st.nextToken());
                bronze=Integer.parseInt(st.nextToken());
                country.add(new Medal(countryNum, gold, silver, bronze));
            }

            int[] rankList=new int[n+1];
            for(int i=0; i<country.size(); i++){
                int rank=1;
                for(int j=0; j<country.size(); j++){
                    if(j==i)
                        continue;
                    if(country.get(i).compareTo(country.get(j))==-1){
                        rank++;
                    }
                }
                rankList[country.get(i).getCountryNum()]=rank;
            }

//            for(int i=1; i<=n; i++){
//                System.out.print(rankList[i]+" ");
//            }
//            System.out.println();

            System.out.println(rankList[k]);

        }catch (Exception e){
            System.exit(0);
        }
    }
}
