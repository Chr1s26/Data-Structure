import java.util.HashMap;

public class containDuplicate2{
    public static void main(String[] args){
        int[] nums = {1,0,1,1};
        int k = 1;
        boolean ans = containsNearbyDuplicate(nums, k);
        System.out.print(ans);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> ans = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(ans.containsKey(nums[i])){
                if(k >= i - ans.get(nums[i])){
                    return true;
                }
            }
            ans.put(nums[i],i);
        }
        return false;
    }
}