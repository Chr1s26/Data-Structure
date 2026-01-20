public class SmallestDivisor{
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for(int i = 0; i < nums.length; i++){
            right = Math.max(right,nums[i]);
        }

        while(left < right){
            int mid = left + ((right - left)/2);  

            if(checkValid(mid,nums,threshold)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    
    public boolean checkValid(int mid, int[] nums, int threshold){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] + mid - 1)/ mid;
        }
        return sum <= threshold;
    }
}