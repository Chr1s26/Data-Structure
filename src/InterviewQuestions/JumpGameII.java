public class JumpGameII{
    public static void main(String[] args){

    }
    
    public int jump(int[] nums) {
        int currentEnd = 0;
        int jump = 0;
        int furthest = 0;

        for(int i = 0; i < nums.length-1; i++){
            furthest = Math.max(furthest,nums[i] + i);

            if(i == currentEnd){
                jump++;
                currentEnd = furthest;
            }
        }

        return jump;
    }
}