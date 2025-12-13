
import java.util.HashMap;

public class TwoSum{
    public static void main(String[] args) {
        int[] nums = {2,7,11,15} ;
        int target = 9;
        int[] ans1 = twoSum(nums, target);
        for(int i = 0; i < ans1.length; i++){
            System.out.print(ans1[i]);
        }
        System.out.println();
        int[] ans2 = twoSum(nums, target);
        for(int i = 0; i < ans2.length; i++){
            System.out.print(ans2[i]);
        }
    }

    public static int[] twoSum(int[] nums,int target){
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }
            map.put(target-nums[i],i);
        }
        return ans;
    }

    public static int[] twoSumV2(int[] nums,int target){
        int[] ans = new int[2];
        HashMap<Integer,Integer> temp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(temp.containsKey(complement)){
                ans[0] = temp.get(complement);
                ans[1] = i;
                return ans;
            }
            temp.put(nums[i], i);
        }
        return new int[0];
    }
}