// public class maximumSubArray{
//     public static void main(String[] args){
//         int[] nums = {5,4,-1,7,8};
//         int max = maxSubArray(nums);
//         System.out.print(max);
//     }

//     public static int maxSubArray(int[] nums){
//         int left = 0;
//         int sum = 0;
//         int max = 0;
        
//         for(int right = 0; right < nums.length; right++){
//             sum += nums[right];
//             if(sum < max){
//                 sum -= nums[left];
//                 left++;
//             }else{
//                 max = sum;
//             }
//         }
//         return max;
//     }

// }

// //  -2,1,-3,4,-1,2,1,-5,4
// //. II (sum = -2 => )
// //   