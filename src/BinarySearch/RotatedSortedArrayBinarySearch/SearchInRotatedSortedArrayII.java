public class SearchInRotatedSortedArrayII{
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target) return true;

            if(nums[left] == nums[mid] && nums[right] == nums[mid]){
                left = left + 1;
                right = right - 1;
            }else if(nums[left] > nums[mid]){
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else if (nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}