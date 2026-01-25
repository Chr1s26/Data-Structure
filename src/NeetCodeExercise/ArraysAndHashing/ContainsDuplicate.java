import java.util.*;

public class ContainsDuplicate{
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int k : map.keySet()){
            if(map.get(k) > 1){
                return true;
            }
        }

        return false;
    }
}