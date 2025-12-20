public class maximumSubArray {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        int max = maxSubArray(nums);
        System.out.println(max);
        int max1 = maxSubArrayI(nums);
        System.out.print(max1);
    }

    public static int maxSubArrayI(int[] nums){
        int curr = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            curr = Math.max(nums[i], nums[i] + curr);
            max = Math.max(curr,max);
        }

        return max;
    }


    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
    
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
