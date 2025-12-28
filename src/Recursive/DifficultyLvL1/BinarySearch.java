public class BinarySearch{
    public static void main(String[] args){
        
    }

    public static int search(int[] nums, int target) {
        return BinarySearch(0,nums.length-1,nums,target);
    }

    public static int BinarySearch(int left, int right, int[] nums, int target){
        if(right < left) return -1;
        int index = left + (right - left) / 2;
        if(nums[index] == target) {
            return index;
        }else if(nums[index] > target){
            index = BinarySearch(left,index - 1,nums,target);
        }else if(nums[index] < target){
            index = BinarySearch(index + 1,right,nums,target);
        }
        return index;
    }
}