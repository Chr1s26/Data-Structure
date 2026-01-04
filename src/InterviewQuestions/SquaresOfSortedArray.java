public class SquaresOfSortedArray{
    public static void main(String[] args){

    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                res[i] = nums[right] * nums[right];
                right--;
            }else{
                res[i] = nums[left] * nums[left];
                left++;
            }
        }

        return res;
    }
}