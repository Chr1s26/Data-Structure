public class FindFirstAndLastPositionOfElement{
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        return new int[]{searchStartIndex(nums,target),searchEndIndex(nums,target)};
    }

    public int searchStartIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right- left)/2; 

            if(nums[mid] >= target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }

        if(nums[right] == target){
            return right;
        }

        return -1;
    }

    public int searchEndIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right- left + 1)/2;

            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] <= target){
                left = mid;
            }
        }

        if(nums[left] == target){
            return left;
        }

        return -1;
    }
}