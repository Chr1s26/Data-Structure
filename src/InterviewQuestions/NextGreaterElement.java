import java.util.*;

public class NextGreaterElement{
    public static void main(String[] args){

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < nums2.length;i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                hm.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            hm.put(stack.pop(),-1);
        }
        int[] ans = new int[nums1.length];
        for(int j = 0; j < nums1.length; j++){
            ans[j] = hm.get(nums1[j]);
        }
        return ans;
    }
}