public class FindSmallestDivisor{
    public static void main(String[] args){

    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i],max);
        }

        int left = 1;
        int right = max;

        while(left < right){

            int mid = left + (right-left)/2;

            if(isSmallerThan(nums,threshold,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }

        }

        return left;
    }


    public boolean isSmallerThan(int[] nums,int threshold,int mid){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += Math.ceil((double)nums[i] / mid) ;
        }
        if(sum > threshold){
            return false;
        }else{
            return true;
        }
    }
}