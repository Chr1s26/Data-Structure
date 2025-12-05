public class maximumAverageSubarrayI{
    public static void main(String[] args){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double max = findMaxAverage(nums,k);
        System.out.print(max);
    }

    public static double findMaxAverage(int[] nums, int k) {
        double max = 0;
        int sum = 0;
        double avg = 0;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        avg = (double) sum / k ;
        max = avg;

        for(int j = k; j < nums.length; j++){
            sum += nums[j];
            sum -= nums[j-k];
            avg = (double) sum/k;
            max = Math.max(avg,max);
        }

        return max;
    }

}
