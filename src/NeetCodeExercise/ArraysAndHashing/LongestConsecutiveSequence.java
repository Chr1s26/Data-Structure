import java.util.*;

public class LongestConsecutiveSequence{


        // total time complexity = n
        //space complexity = n
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int max = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                int current = n;
                int count = 1;
                
                while(set.contains(current+1)){
                    current++;
                    count++;
                }

                max = Math.max(count,max);
            }
        }
        return max;
    }

        // total time complexity = n log n
    public int longestConsecutiveV2(int[] nums) {
        if(nums.length == 0) return 0;
        //sort time complexity n log(n)
        Arrays.sort(nums);
        int count = 1;
        int max = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }else if(nums[i] == nums[i-1] + 1){
                count++;
                max = Math.max(max,count);
            }else{
                max = Math.max(max,count);
                count = 1;
            }
        }

        return max;
    }
}