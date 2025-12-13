import java.util.HashMap;
import java.util.Map;

public class containDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean flag = containsNearbyDuplicate(nums, k);
        System.out.print(flag);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
          
            if (map.containsKey(num)) {
                int prevIndex = map.get(num);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }

        return false;
    }
}
