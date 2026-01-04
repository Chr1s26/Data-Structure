import java.util.*;
public class ThreeSum{
    public static void main(String[] args){

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length-1;
            

            while(left < right){

                int sum = nums[left] + nums[right] + nums[i];

                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    temp.add(nums[i]);
                    ans.add(temp);

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;

                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return ans;
    }
}