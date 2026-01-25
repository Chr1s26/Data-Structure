import java.util.*;

public class TopKFrequentElement{
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int[] ans = new int[k];

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int key : map.keySet()){
            int[] temp = new int[2];
            temp[0] = key;
            temp[1] = map.get(key);
            maxHeap.offer(temp);
        }

        for(int i = 0; i < k; i++){
            ans[i] = maxHeap.poll()[0];
        }

        return ans;
    }
}