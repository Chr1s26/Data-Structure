
import java.util.*;

public class TopKFrequentElement{
    public static void main(String[] args){

        int[] nums = {5,3,1,1,1,3,73,1};  
        int k = 2;
        int[] ans1 = topKFrequent(nums, k);
        for(int i : ans1){
            System.out.print(i);
        }
        System.err.println("");
        int[] ans2 = topKFrequentV2(nums, k);
        for(int i : ans2){
            System.out.print(i);
        }
        System.err.println("");
        int[] ans3 = topKFrequentV3(nums, k);
        for(int i : ans3){
            System.out.print(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k){
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,List<Integer>> reverse = new HashMap<>();
        TreeSet<Integer> tree = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);  
        }

        for(Integer key : map.keySet()){
            tree.add(map.get(key));
        }

        for(Integer key : map.keySet()){
            reverse.computeIfAbsent(map.get(key), t -> new ArrayList<>()).add(key);
        }

        int flag = 0;
        for(int i = 0; i < k; i++){
            int temp = tree.pollLast();
            flag = 0;
            for(int j : reverse.get(temp)){
                if(flag > 0){
                    i++;
                }
                ans[i] = j;

                flag++;
            }
        }


        return ans;
    }

    public static int[]  topKFrequentV2(int[] nums, int k){ // 1 2 3 4 5
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        int index = 0;
        for(int n : nums){
            map.put(n,map.getOrDefault(n, 0) + 1);
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for(int key : map.keySet()){
            int value = map.get(key);
            if(bucket[value] == null) bucket[value] = new ArrayList<>();
            bucket[value].add(key);
        }

        for(int j = nums.length; j >= 0 && index < k ; j--){
            if(bucket[j] != null) {
                for(int v : bucket[j]){
                     ans[index++] =v;
                     if(index == k) break;
                }
            }
        }
        return ans;
    }

    public static int[] topKFrequentV3(int[] nums, int k){

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(Integer key : map.keySet()){
            heap.offer(new int[]{key,map.get(key)});
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] ans = new int[k];

        for(int i = k - 1; i >= 0; i--){
            ans[i] = heap.poll()[0];
        }

        return ans;
    }
}