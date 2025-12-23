import java.util.*;

public class findKLargest{
    public static void main(String[] args){
        System.out.println(find(new int[]{3,2,1,5,6,4},2)); //1,2,4,5,6 => len = 5.
        System.out.println(findV1(new int[]{3,2,1,5,6,4},2));
    } 

    public static int find(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        }

        int count = 0;
        int ans = 0;   
        while(count != k){
            ans = pq.poll();
            count++;
        }
        return ans;
    }

    public static int findV1(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k ];
    }
}