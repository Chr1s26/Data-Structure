public class SingleNumber{
    public static void main(String[] args){

    }

    public static int findSingleNumber(int[] nums){
        int xor = nums[0];

        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }
        return xor;
    }
}