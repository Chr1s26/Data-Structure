import java.util.*;

public class BrickWall{
    public static void main(String[] args){

    }

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(List<Integer> li : wall){
            int sum = 0;
            for(int i = 0; i < li.size() - 1; i++){
                sum += li.get(i);
                hm.put(sum,hm.getOrDefault(sum,0) + 1);
            }
        }


        int max = 0;

        for(int key : hm.keySet()){
            max = Math.max(max,hm.get(key));
        }
    
        return wall.size() - max;
    }
}