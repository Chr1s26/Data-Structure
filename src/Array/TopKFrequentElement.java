
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TopKFrequentElement{
    public static void main(String[] args){
        int[] nums = {5,3,1,1,1,3,73,1};  
        int k = 2;
        int[] ans = topKFrequent(nums, k);
        for(int i : ans){
            System.out.print(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k){
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,List<Integer>> reverse = new HashMap<>();
        TreeSet<Integer> tree = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);  
        }

        for(Integer key : map.keySet()){
            tree.add(map.get(key));
        }

        for(Integer key : map.keySet()){
            reverse.computeIfAbsent(map.get(key), t -> new ArrayList<>()).add(key);
        }

        int flag = 0;
        for(int i = 0; i < k; i++){
            int temp = tree.pollLast();
            flag = 0;
            for(int j : reverse.get(temp)){
                if(flag > 0){
                    i++;
                }
                ans[i] = j;

                flag++;
            }
        }


        return ans;
    }
}