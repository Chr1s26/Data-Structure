public class maximumAverageSubarrayI{
    public static void main(String[] args){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double max = findMaxAverage(nums,k);
        System.out.println(max);
        double max1 = findMaxAverageI(nums,k);
        System.out.print(max1);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        int max = sum;

        for(int j = k; j < nums.length; j++){
            sum += nums[j];
            sum -= nums[j-k];
            max = Math.max(sum,max);
        }
        return (double) max / k ;
    }

    public static double findMaxAverageI(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        int curr = 0;
        double avg = 0.0;
        double max = - Double.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            count++;
            if(count == k){
                avg = (double) sum / k;
                max = Math.max(max,avg);
                sum -= nums[curr];
                curr++;
                count--;
            }
        }

        return max;
    }

}
